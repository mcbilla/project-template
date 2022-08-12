package com.mcb.design.pattern.singleton;

/**
 * 第二种，懒汉模式，类初始化时，不会初始化该对象，真正需要使用的时候才会创建该对象，具备懒加载功能。
 *
 * 优点：实现了懒加载，节约了内存空间
 *
 * 缺点：在不加锁的情况下，线程不安全，可能出现多份实例；在加锁的情况下，会是程序串行化，使系统有严重的性能问题
 */
public class Singleton2 {
    private static Singleton2 singleton2;

    private Singleton2() {}

    public static Singleton2 getInstance() { // 线程不安全，可以在这里加synchronized关键字，但是会存在性能问题
        if(singleton2 == null) {
            singleton2 = new Singleton2();
        }
        return singleton2;
    }
}
