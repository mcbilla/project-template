package com.mcb.design.pattern.iterator;

public interface Container {
    void add(Object object);

    void remove(Object object);

    Iterator iterator();
}
