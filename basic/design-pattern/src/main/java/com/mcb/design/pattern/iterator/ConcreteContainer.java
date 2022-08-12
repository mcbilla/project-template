package com.mcb.design.pattern.iterator;

import java.util.Vector;

/**
 * 容器实现类，一般会提供类似于 iterator() 的方法用于返回迭代器
 */
public class ConcreteContainer implements Container{
    private Vector vector = new Vector();

    @Override
    public void add(Object object) {
        vector.add(object);
    }

    @Override
    public void remove(Object object) {
        vector.remove(object);
    }

    @Override
    public Iterator iterator() {
        return new ConcreteIterator(vector);
    }
}
