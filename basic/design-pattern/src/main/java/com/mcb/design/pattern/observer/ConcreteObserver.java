package com.mcb.design.pattern.observer;

public class ConcreteObserver implements Observer{
    @Override
    public void update(String msg) {
        System.out.println("observer1收到消息" + msg);
    }

}
