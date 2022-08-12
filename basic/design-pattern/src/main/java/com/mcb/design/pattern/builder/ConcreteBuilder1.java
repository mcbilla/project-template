package com.mcb.design.pattern.builder;

import java.util.Date;

/**
 * Builder实现类，这个类主要实现复杂对象创建的哪些部分需要什么属性
 */
public class ConcreteBuilder1 implements Builder{
    private Product product;

    public ConcreteBuilder1() {
        this.product = new Product();
    }

    @Override
    public void buildName() {
        product.setName("111");
    }

    @Override
    public void buildNumber() {
        product.setNumber(1);
    }

    @Override
    public void buildProduceDate() {
        product.setProduceDate(new Date());
    }

    @Override
    public void buildOrigin() {
        product.setOrigin("aaa");
    }

    @Override
    public Product getProduct() {
        return product;
    }
}
