package com.mcb.registry.curator;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Slf4j
@Component
public class CuratorUtils {

    // 连接zk的客户端，使用单例模式初始化
    private static volatile CuratorFramework curatorClient = null;

    /**
     * 这三个都是静态变量，只能通过这种方式通过@Value注入
     */
    public static String registryAddress;

    @Value("${zk.registry.address}")
    public void setRegistryAddress(String name) {
        CuratorUtils.registryAddress = name;
    }

    public static int sessionTimeout;

    @Value("${zk.session.timeout}")
    public void setSessionTimeout(int sessionTimeout) {
        CuratorUtils.sessionTimeout = sessionTimeout;
    }

    public static int connectionTimeout;

    @Value("${zk.connection.timeout}")
    public void setConnectionTimeout(int connectionTimeout) {
        CuratorUtils.connectionTimeout = connectionTimeout;
    }

    /**
     * 私有构造方法，防止被实例化，只能调用静态方法
     */
    private CuratorUtils() {
    }

    /**
     * 单例模式初始化curatorClient
     * @return
     */
    private static CuratorFramework getClient() {
        if (curatorClient == null) {
            synchronized (CuratorUtils.class) {
                if (curatorClient == null) {
                    curatorClient = CuratorFrameworkFactory.builder()
                            // Zookeeper 服务器地址字符串
                            .connectString(registryAddress)
                            // 连接超时时间
                            .connectionTimeoutMs(connectionTimeout)
                            // session 会话超时时间
                            .sessionTimeoutMs(sessionTimeout)
                            // 使用哪种重连策略，可重连3次，并增加每次重连之间的睡眠时间
                            .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                            .build();
                    curatorClient.start();
                    return curatorClient;
                }
            }
        }
        return curatorClient;
    }

    /**
     * 容器销毁前关闭连接
     */
    @PreDestroy
    private void close() {
        curatorClient.close();
    }

    /**
     * 创建节点
     * @param path
     * @param data
     */
    public static void createNode(final String path, String data) {
        CuratorFramework client = getClient();
        try {
            if (client.checkExists().forPath(path) == null) {
                String rs = client.create().creatingParentsIfNeeded().forPath(path, data.getBytes());
                log.info("createNode success {} {}", rs, data);
            } else {
                log.info("createNode fail, node already exist");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 更新节点
     *
     * 普通更新 client.setData().forPath(path,"新内容".getBytes());
     * 指定版本更新 client.setData().withVersion(1).forPath(path);
     * @param path
     * @param data
     */
    public static void updateNode(final String path, String data) {
        CuratorFramework client = getClient();
        try {
            if (client.checkExists().forPath(path) != null) {
                client.setData().forPath(path, data.getBytes());
                log.info("updateNode success {} {}", path, data);
            } else {
                log.info("updateNode fail");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取节点数据
     *
     * 使用节点当前的Stat替换到传入的Stat的方法，查询方法执行完成之后，Stat引用已经执行当前最新的节点Stat。
     * @param path
     * @return
     */
    public static String getNode(final String path) {
        CuratorFramework client = getClient();
        try {
            Stat stat = new Stat();
            byte[] nodeData = client.getData().storingStatIn(stat).forPath(path);
            return new String(nodeData);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 判断节点是否存在
     * @param path
     * @return
     */
    public static Boolean existNode(final String path) {
        CuratorFramework client = getClient();
        try {
            return client.checkExists().forPath(path) != null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 监控节点数据更新
     *
     * PathChildrenCache是专门用来监听指定节点 的子节点变化情况
     * @param path
     */
    public static void watchNode(final String path) {
        CuratorFramework client = getClient();
        try {
            PathChildrenCache pathChildrenCache = new PathChildrenCache(client, path, true);
            pathChildrenCache.start(PathChildrenCache.StartMode.NORMAL);
            pathChildrenCache.getListenable().addListener(new PathChildrenCacheListener() {

                @Override
                public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent event) throws Exception {
                    if(event.getType().equals(PathChildrenCacheEvent.Type.INITIALIZED)){
                        log.info("子节点初始化ok...");
                    }
                    else if(event.getType().equals(PathChildrenCacheEvent.Type.CHILD_ADDED)){
                        log.info("添加子节点:" + event.getData().getPath());
                        log.info("子节点数据:" + new String(event.getData().getData()));
                    }else if(event.getType().equals(PathChildrenCacheEvent.Type.CHILD_REMOVED)){
                        log.info("删除子节点:" + event.getData().getPath());
                    }else if(event.getType().equals(PathChildrenCacheEvent.Type.CHILD_UPDATED)){
                        log.info("修改子节点路径:" + event.getData().getPath());
                        log.info("修改子节点数据:" + new String(event.getData().getData()));
                    }
                }
            });

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 删除节点
     *
     * 删除一个子节点 client.delete().forPath(path);
     * 删除节点并递归删除其子节点 client.delete().deletingChildrenIfNeeded().forPath(path);
     * 指定版本进行删除 client.delete().withVersion(1).forPath(path);
     * 强制保证删除一个节点 client.delete().guaranteed().forPath(path);
     * @param path
     */
    public static void deleteNode(final String path) {
        CuratorFramework client = getClient();
        try {
            client.delete().deletingChildrenIfNeeded().forPath(path);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
