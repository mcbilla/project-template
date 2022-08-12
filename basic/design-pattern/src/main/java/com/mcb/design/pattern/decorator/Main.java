package com.mcb.design.pattern.decorator;

/**
 * 装饰器模式，创建了一个装饰类，用来包装原有的类，并在保持类方法签名完整性的前提下，提供了额外的功能。
 *
 * 使用场景：
 * 1、扩展一个类的功能。 2、动态增加功能，动态撤销。
 *
 * 装饰器模式和适配器模式的区别？
 * 适配器模式的目的是改变接口，要将一个接口转变成另外一个接口。实现做法就是适配器实现一个新的接口，把原来的对象作为成员变量传进去，在实现新接口的方法里面可能会舍弃原来对象的功能
 * 装饰器模式的目的是增强接口，在保持原有的接口的基础上，增强原有对象的功能。实现做法就是装饰器实现原来的接口，把原来的对象作为成员变量传进去，在在实现原来接口的方法里面一般会先调用原来对象的功能，然后再做增强处理
 *
 * 装饰器模式和代理模式的区别？
 * 相同点：
 * 1、装饰者（decorator）和被装饰者（decoratee）都实现同一个接口，代理类（proxy class）和真实处理的类（real class）也是实现同一个接口。
 * 2、都会把原来的对象作为成员变量传入一个新的类（装饰器类/代理类），然后再在调用原来对象的功能的基础上，加一些其他处理。
 * 区别是：
 * 装饰器模式应当为所装饰的对象提供增强功能，而代理模式对所代理对象的使用施加控制，并不提供对象本身的增强功能。
 *
 * 示例：
 * 比如我们睡醒去上班，可以选择穿上衣A和裤子A，也可以选择穿上衣A和裤子B，不管穿哪套衣服，最后都要出门上班。
 */
public class Main {
    public static void main(String[] args) {
        // 没穿衣服的用户A
        User user = new UserA();

        // 用户穿上ShirtA
        UserOnShirtA userOnShirtA = new UserOnShirtA(user);

        // 用户穿上ShirtA+PantsA去上班
        new UserOnPantsA(userOnShirtA).goToWork();
        System.out.println("----------");

        // 也可以复用上面的userOnShirtA，让用户穿上ShirtA+PantsB去上班，装饰器新增每一层装饰功能不会影响上一层的功能，每一层都可以复用
        new UserOnPantsB(userOnShirtA).goToWork();
        System.out.println("----------");

        // 当然没穿的用户A也可以直接去上班，装饰器更不会影响没有使用装饰器的正常功能
        user.goToWork();
    }
}
