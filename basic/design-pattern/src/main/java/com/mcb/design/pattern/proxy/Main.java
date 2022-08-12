package com.mcb.design.pattern.proxy;

import com.mcb.design.pattern.proxy.entity.AliServer;
import com.mcb.design.pattern.proxy.entity.AwsServer;
import com.mcb.design.pattern.proxy.entity.Server;
import com.mcb.design.pattern.proxy.entity.TencentServer;
import com.mcb.design.pattern.proxy.proxy1.AliServerProxy;
import com.mcb.design.pattern.proxy.proxy1.AwsServerProxy;
import com.mcb.design.pattern.proxy.proxy2.JdkServerProxy;
import com.mcb.design.pattern.proxy.proxy3.CglibServerProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 代理模式，是指用一个代理类去代表另一个类的功能，通过代理类控制对实际类的访问。
 * <p>
 * 优点：
 * 是可以增强目标对象的功能，降低代码耦合度，扩展性好。
 * <p>
 * 缺点：
 * 在客户端和目标对象之间增加代理对象会导致请求处理速度变慢，增加系统复杂度。
 * <p>
 * 代理模式的应用场景：
 * Spring AOP、日志打印、异常处理、事务控制、权限控制等
 * <p>
 * 代理模式的类型：
 * 静态代理：在编译的时候就已经生成代理类的字节码文件，代理类和委托类的关系在运行前就确定了。每个需要代理的对象都需要自己重复编写代理，比较麻烦。
 * jdk动态代理：使用反射完成代理，动态的在内存中构建代理对象。被代理的类必须继承接口。
 * cglib动态代理：使用反射完成代理，和jdk代理不同，可以直接代理没有实现接口的类，底层使用asm字节码技术，比jdk代理性能更好，但不能对final类进行代理。
 *
 * 示例：
 * 假如有一个Server接口和旗下子类AliServer和AwsServer，还有一个没有继承Server接口的类TecentServer。
 * 我们想在这几个Server类执行run方法前后加入一些其他业务处理。
 */
public class Main {
    public static void main(String[] args) {
        // 静态代理，每需要新增一种代理功能时就需要新增一种代理类，比较繁琐
        Server aliServerProxy1 = new AliServerProxy(new AliServer());
        aliServerProxy1.run();
        Server awsServerProxy1 = new AwsServerProxy(new AwsServer());
        awsServerProxy1.run();

        // jdk动态代理，在调用的时候才会在内存中动态生产代理类，只需要一个代理类就可以实现多个类的代理
        // 1、获取被代理的对象
        AliServer aliServer = new AliServer();
        AwsServer awsServer = new AwsServer();
        // 2、获取InvocationHandler对象
        InvocationHandler aliInvocationHandler = new JdkServerProxy(aliServer);
        InvocationHandler awsInvocationHandler = new JdkServerProxy(awsServer);
        // 3、jdk动态代理，代理后的类型必须是接口或子类类型
        Server aliServerProxy2 = (Server) Proxy.newProxyInstance(
                aliServer.getClass().getClassLoader(), // classloader
                aliServer.getClass().getInterfaces(), // interface
                aliInvocationHandler);
        Server awsServerProxy2 = (Server) Proxy.newProxyInstance(
                awsServer.getClass().getClassLoader(), // classloader
                awsServer.getClass().getInterfaces(), // interface
                awsInvocationHandler);
        aliServerProxy2.run();
        awsServerProxy2.run();

        // cglib动态代理，可以对没有继承接口的类也进行代理
        // 使用前记得先加入cglib依赖
        CglibServerProxy cglibServerProxy = new CglibServerProxy();
        // 代理后的类型是类原来的类型，不需要转换成接口或子类类型
        TencentServer tencentServerProxy = (TencentServer) cglibServerProxy.getInstance(new TencentServer());
        tencentServerProxy.run();
    }
}
