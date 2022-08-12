package com.mcb.design.pattern.proxy.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JdkServerProxy implements InvocationHandler {
    // 这里的目标类型为Object，则可以接受实现接口的类作为被代理类，实现了动态代理
    private Object target;

    public JdkServerProxy(Object target) {
        this.target = target;
    }

    // 代理执行方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk动态代理模式前置处理");
        Object result = method.invoke(target, args);
        System.out.println("jdk动态代理模式后置处理");
        // 返回代理对象
        return result;
    }
}
