package com.mcb.design.pattern.singleton;

/**
 * 第三种，双重检查锁，是懒汉模式的线程安全版本，且不存在性能问题
 *
 * 优点：兼顾性能和线程安全的特点，推荐使用
 */
public class Singleton3 {
    /**
     * volatile的作用：禁止指令排序
     *
     * java创建对象分为三步：
     * 1、为对象分配内存空间
     * 2、在内存空间里初始化对象
     * 3、使引用指向分配的内存空间
     *
     * 如果第2和第3步出现重排序，引用指向的内存空间是未初始化完成的对象
     * 但此时引用已经不为null了，按照代码逻辑判断会直接返回该引用，此时会发生空指针异常
     */
    private static volatile Singleton3 singleton3;

    private Singleton3() {}

    public static Singleton3 getInstance() {
        if(singleton3 == null) {
            synchronized (Singleton3.class) {
                if(singleton3 == null) {
                    singleton3 = new Singleton3();
                }
            }
        }
        return singleton3;
    }
}
