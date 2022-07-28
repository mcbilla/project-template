package com.mcb.registry.curator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(classes = CuratorUtils.class)
class CuratorApplicationTests {

    @Test
    void contextLoads() throws InterruptedException {
        System.out.println(CuratorUtils.registryAddress);
        System.out.println(CuratorUtils.connectionTimeout);
        System.out.println(CuratorUtils.sessionTimeout);

        String path = "/mcb/data1";
        String data1 = "aaa";
        String data2 = "bbb";

        System.out.println("创建节点");
        CuratorUtils.createNode(path, data1);
        System.out.println(CuratorUtils.getNode(path));

        System.out.println("监控节点");
        CuratorUtils.watchNode(path);

        Thread.sleep(2000);

        System.out.println("判断节点是否存在");
        System.out.println(CuratorUtils.existNode(path));

        System.out.println("更新节点");
        CuratorUtils.updateNode(path, data2);
        System.out.println(CuratorUtils.getNode(path));

        System.out.println("删除节点");
        CuratorUtils.deleteNode(path);
        System.out.println(CuratorUtils.existNode(path));
    }

}
