package com.mcb.design.pattern.observer;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcreteSubject implements Subject{
    private ConcurrentLinkedQueue<Observer> queue = new ConcurrentLinkedQueue<>();

    private String msg;

    /**
     * 主题更新消息
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        queue.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if(queue.size() > 0 && queue.contains(observer)) {
            queue.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        queue.forEach(o -> {
            o.update(msg);
        });
    }
}
