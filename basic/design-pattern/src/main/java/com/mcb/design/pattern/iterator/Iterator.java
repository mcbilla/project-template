package com.mcb.design.pattern.iterator;

public interface Iterator {
    Object next();    //遍历到下一个元素

    boolean hasNext();    //是否已经遍历到尾部
}
