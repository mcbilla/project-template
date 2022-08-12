package com.mcb.design.pattern.singleton;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 单例模式是指整个应用中有且只有一个实例
 *
 * 优点：
 * 可以避免因为创建了多个实例造成资源的浪费。
 *
 * 实现单例模式的过程：
 * 1、私有构造函数，防止外界通过new创建对象（实际上目前除了枚举模式，其他模式还是可以通过反射创建对象）
 * 2、在类内部通过new创建一个本类的对象（类内部的static变量指向本类实例，jdk1.7以前static变量放在方法区，jdk1.7以后static变量是放在类的Class文件里面，都可以保证只要类没有被销毁，static引用指向的类实例就不会被gc回收）。
 * 3、向外提供一个public方法获取第2步创建的对象。
 *
 * 单例模式目前的实现方法：
 * 1、饿汉模式
 * 2、懒汉模式（线程不安全）
 * 3、双重校验锁（懒汉模式的线程安全版本）
 * 4、静态内部类
 * 5、枚举类
 *
 * 其他注意事项：
 *
 * 1、多个线程同时访问操作单例对象，需不需要加锁？
 * 如果多个线程同时修改单例对象的同一个成员变量，就需要加锁。
 * 如果多个线程只是读取单例对象的成员变量，或者只是调用单例对象的方法但方法里面不涉及到成员变量（调用方法里面的局部变量也不存在线程安全问题），就不需要加锁。
 */
public class Main {
    private static ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 10, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));

    public static void main(String[] args) {
        for (; ; ) {
            pool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + ":" + Singleton5.getInstance());
            });
        }
    }
}
