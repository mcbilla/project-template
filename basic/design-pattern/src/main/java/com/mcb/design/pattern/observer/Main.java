package com.mcb.design.pattern.observer;

/**
 * 观察者模式，定义了对象之间的一对多的依赖，这样一来，当一个对象改变时，它的所有的依赖者都会收到通知并自动更新。
 *
 * 实现过程：
 * 观察者模式通常有四种角色：
 * Subject：抽象主题，它把所有对观察者对象的引用文件存在了一个聚集里，每个主题都可以有任何数量的观察者。抽象主题提供了一个接口，可以增加和删除观察者对象。
 * ConcreteSubject：具体主题，将有关状态存入具体观察者对象，在具体主题内部状态改变时，给所有登记过的观察者发出通知
 * Observer：抽象观察者，为所有的具体观察者定义一个接口，在得到主题的通知时更新自己。
 * ConcreteObserver：具体观察者，实现抽象观察者角色所要求的更新接口，以便使本身的状态与主题的状态相协同。
 */
public class Main {
    public static void main(String[] args) {
        // 设置主题
        ConcreteSubject subject = new ConcreteSubject();

        // 设置多个观察者
        ConcreteObserver observer1 = new ConcreteObserver();
        ConcreteObserver observer2 = new ConcreteObserver();
        ConcreteObserver observer3 = new ConcreteObserver();

        // 添加观察者
        subject.registerObserver(observer1);
        subject.registerObserver(observer2);
        subject.registerObserver(observer3);

        // 更新消息，每次更新所有观察者都能收到消息
        subject.setMsg("消息1");
        subject.setMsg("消息2");
    }
}
