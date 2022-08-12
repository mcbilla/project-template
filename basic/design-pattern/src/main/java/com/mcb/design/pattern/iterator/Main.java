package com.mcb.design.pattern.iterator;

/**
 * 迭代器模式，用于顺序访问集合对象的元素，不需要知道集合对象的底层表示。
 *
 * 实现过程：
 * 迭代器模式一般包含以下对象：
 * Iterator：迭代器接口，用于定义迭代器可提供的功能，例如得到开始对象、得到下一个对象、判断是否到结尾等方法
 * ConcreteIterator：迭代器实现类。
 * Container：容器接口，一般会提供一个类似于 iterator() 的方法用于返回迭代器。
 * ConcreteContainer：容器实现类。
 *
 * 应用场景：
 * 1、访问一个聚合对象的内容而无须暴露它的内部表示。
 * 2、需要为聚合对象提供多种遍历方式。
 * 3、为遍历不同的聚合结构提供一个统一的接口。
 *
 * 优点：
 * 1、它支持以不同的方式遍历一个聚合对象。
 * 2、迭代器简化了聚合类。
 * 3、在同一个聚合上可以有多个遍历。
 * 4、在迭代器模式中，增加新的聚合类和迭代器类都很方便，无须修改原有代码。
 *
 * 缺点：
 * 由于迭代器模式将存储数据和遍历数据的职责分离，增加新的聚合类需要对应增加新的迭代器类，类的个数成对增加，这在一定程度上增加了系统的复杂性。
 */
public class Main {
    public static void main(String[] args) {
        ConcreteContainer container = new ConcreteContainer();
        for (int i = 0; i < 10; i++) {
            container.add(i);
        }
        ConcreteIterator iterator = (ConcreteIterator) container.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
