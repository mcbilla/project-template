package com.mcb.design.pattern.iterator;

import java.util.Vector;

/**
 * 简单的实现就是传入一个容器，然后通过一个游标在容器中上下翻滚，遍历所有它需要查看的元素。
 */
public class ConcreteIterator implements Iterator{
    private Vector vector;

    private int cursor = 0;

    public ConcreteIterator(Vector vector) {
        this.vector = vector;
    }

    @Override
    public Object next() {
        if(hasNext()) {
            return vector.get(cursor++);
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        if(this.cursor == vector.size()) {
            return false;
        }
        return true;
    }
}
