package com.mcb.design.pattern.singleton;

/**
 * 第四种，静态内部类，内部静态类不会自动初始化，只有调用静态内部类的方法，静态域，或者构造方法的时候才会加载静态内部类。
 *
 * 优点：同时兼具性能和线程安全的特点，推荐使用
 *
 * 静态内部类为什么线程安全？
 * JVM虚拟机会保证一个类的类构造器<clinit>()在多线程环境中被正确的加锁、同步。
 * 如果多个线程同时去初始化一个类，那么只会有一个线程去执行这个类的类构造器<clinit>()。
 * 其他的线程都需要阻塞等待，直到活动线程执行()方法完毕。
 * 所以在同一个类加载器下，一个类只会被初始化一次，这个类的初始化的<clinit>代码也只会被执行一次，所以他只会有一个实例。
 *
 * 补充：
 * 1、一个线程执行类初始化操作，其他线程虽然会被阻塞，但是执行类初始化的线程退出后，其他线程在被唤醒之后不会进入/执行<clinit>()方法。
 * 2、如果一个类初始化特别慢，就可能造成其他线程阻塞很久，而这种阻塞往往在实际应用中是隐藏的。
 */
public class Singleton4 {
    private static class InstanceHolder {
        private static final Singleton4 singleton4 = new Singleton4();
    }

    private Singleton4() {}

    public static Singleton4 getInstance() {
        return InstanceHolder.singleton4;
    }
}
