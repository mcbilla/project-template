package com.mcb.design.pattern.singleton;

/**
 * 第一种，饿汉模式，最简单的模式
 *
 * 优点：类初始化时，会立即加载该对象，线程天生安全，调用效率高。
 *
 * 缺点：不能实现懒加载，造成空间浪费，如果一个类比较大，我们在初始化的时就加载了这个类，但是我们长时间没有使用这个类，这就导致了内存空间的浪费。
 */
public class Singleton1 {
    private static Singleton1 singleton1 = new Singleton1();

    private Singleton1() {}

    public static Singleton1 getInstance() {
        return singleton1;
    }
}
