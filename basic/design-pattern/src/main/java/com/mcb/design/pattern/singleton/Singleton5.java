package com.mcb.design.pattern.singleton;

/**
 * 第五种，枚举类
 *
 * 优点：
 * 1、实现简单、调用效率高，枚举本身就是单例，由jvm从根本上提供保障
 * 2、唯一一种不会被破坏的单例实现模式，其他模式都可以通过反射创建实例来破坏单例模式
 *
 * 缺点：没有延迟加载。
 */
public class Singleton5 {
    private enum InstanceHolder {
        INSTANCE;

        private Singleton5 singleton5;

        private InstanceHolder() {
            singleton5 = new Singleton5();
        }

        public Singleton5 getSingleton5() {
            return singleton5;
        }
    }

    private Singleton5() {}

    public static Singleton5 getInstance() {
        return InstanceHolder.INSTANCE.getSingleton5();
    }
}
