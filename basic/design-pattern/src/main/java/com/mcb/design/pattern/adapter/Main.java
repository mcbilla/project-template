package com.mcb.design.pattern.adapter;

/**
 * 适配器模式，作为两个不兼容的接口之间的桥梁，将一个类的接口转换成客户期望的另一个接口，适配器让原本接口不兼容的类可以相互合作。
 *
 * 应用场景：
 * 1、系统需要使用现有的类，而此类的接口不符合系统的需要(核心需求)。
 * 2、用于与一些彼此之间没有太大关联的一些类，包括一些可能在将来引进的类一起工作，这些源类不一定有一致的接口，但通过适配器使得它们都具有一致的接口。
 *
 * 实现：
 * 适配器模式一般包含以下三个角色：
 * Target（目标接口）：所要转换的所期待的接口。
 * Adaptee（源角色）：需要适配的接口。
 * Adapter（适配器）：将源接口适配成目标接口，实现目标接口。
 * 通常有两种方式实现适配器模式
 * 1、类适配器，类适配器目前已不太使用。类适配器通过继承现有接口类并实现目标接口，这样的话会使得现有接口类完全对适配器暴露，使得适配器具有现有接口类的全部功能，破坏了封装性。
 * 2、是对象适配器，通常情况下采用对象适配器会使得代码更易扩展与维护。
 *
 * 示例：
 * 例如美国的正常供电电压为110V，中国造的电器的工作电压是220V，需要一个适配器把110V的接口转换成220V的接口。
 */
public class Main {
    public static void main(String[] args) {
        // 类适配器，直接使用封装好的适配器
        User user1 = new User(new UToCPowerAdapter1());
        user1.charge();

        // 对象适配器，把原来的对象传入适配器，这种方式扩展性更强
        USAPower usaPower = new USAPowerImpl();
        User user2 = new User(new UToCPowerAdapter2(usaPower));
        user2.charge();
    }

    // 用户手里只有适用于220V的电器，所以只能传入220V的充电头
    static class User {
        private ChinaPower chinaPower;

        public User(ChinaPower chinaPower) {
            this.chinaPower = chinaPower;
        }

        public void charge() {
            chinaPower.charge220V();
        }
    }
}
