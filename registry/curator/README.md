### Curator是什么

Curator是Netflix公司开源的一套zookeeper客户端框架，解决了很多Zookeeper客户端非常底层的细节开发工作，包括连接重连、反复注册Watcher和NodeExistsException异常等等。并且提供了一些工具类，还可以更简单的实现例如分布式锁。

相对于ZooKeeper原生Java API的不足之处，Curator提供以下特性：
* 解决Watch注册一次就会失效的问题
* 提供的 API 更加简单易用
* 提供更多解决方案并且实现简单，例如：分布式锁
* 提供常用的ZooKeeper工具类
* 编程风格更舒服

Curator 官网地址：https://curator.apache.org/index.html

Curator Github地址：https://github.com/apache/curator

### Curator项目组件
Curator项目包括以下组件：

| 名称        | 	描述                                                                  |
|-----------|----------------------------------------------------------------------|
| Framework | 	Zookeeper API的高层封装，大大简化Zookeeper客户端编程，添加了例如Zookeeper连接管理、重试机制等。     |
| Recipes   | 	Zookeeper典型应用场景的实现，这些实现是基于Curator Framework。                        |
| Utilities | 	为Zookeeper提供的各种实用程序。                                                |
| Client    | 	Zookeeper client的封装，用于取代原生的Zookeeper客户端（ZooKeeper类），提供一些非常有用的客户端特性。 |
| Errors    | 	Curator如何处理错误，连接问题，可恢复的例外等。                                         |

### Curator可用Maven依赖
Curator打包发布到Maven仓库的有以下依赖组件：（地址:https://search.maven.org/search?q=org.apache.curator）

| GroupID/Org        | 	ArtifactID/Name           | 	描述                                      |
|--------------------|----------------------------|------------------------------------------|
| org.apache.curator | 	curator-recipes	          | 所有典型应用场景。需要依赖client和framework，需设置自动获取依赖。 |
| org.apache.curator | 	curator-framework         | 	同组件中framework介绍。                        |
| org.apache.curator | 	curator-client            | 	同组件中client介绍。                           |
| org.apache.curator | 	curator-test              | 	包含TestingServer、TestingCluster和一些测试工具。  |
| org.apache.curator | 	curator-examples          | 	各种使用Curator特性的案例。                       |
| org.apache.curator | 	curator-x-discovery       | 	在framework上构建的服务发现实现。                   |
| org.apache.curator | 	curator-x-discoveryserver | 	可以喝Curator Discovery一起使用的RESTful服务器。    |
| org.apache.curator | 	curator-x-rpc             | 	Curator framework和recipes非java环境的桥接。    |

绝大数情况下只需要引用`curator-framework`和`curator-recipes`这两个依赖即可。

注意：
1. 目前Curator有2.x.x和3.x.x两个系列的版本，支持不同版本的Zookeeper。其中Curator 2.x.x兼容Zookeeper的3.4.x和3.5.x。而Curator 3.x.x只兼容Zookeeper 3.5.x，并且提供了一些诸如动态重新配置、watch删除等新特性。要根据Zookeeper版本选择合适的Curator版本。
2. Curator框架通过CuratorFrameworkFactory以工厂模式和builder模式创建CuratorFramework实例。 CuratorFramework实例都是线程安全的，你应该在你的应用中共享同一个CuratorFramework实例。

### Reference
https://www.cnblogs.com/qingyunzong/p/8666288.html

https://www.baeldung.com/apache-curator