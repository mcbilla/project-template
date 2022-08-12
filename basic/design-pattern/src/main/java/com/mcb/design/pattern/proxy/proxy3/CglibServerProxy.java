package com.mcb.design.pattern.proxy.proxy3;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibServerProxy implements MethodInterceptor {
    // 这里的目标类型为Object，则可以接受任意一种参数作为被代理类，实现了动态代理
    private Object target;

    // 获取代理对象
    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    // 代理执行方法
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib动态代理模式前置处理");
        Object result = methodProxy.invoke(target, objects);
        System.out.println("cglib动态代理模式后置处理");
        // 返回代理对象
        return result;
    }
}
