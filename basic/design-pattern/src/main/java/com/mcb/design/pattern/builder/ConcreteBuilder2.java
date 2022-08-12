package com.mcb.design.pattern.builder;

import java.util.Date;

public class ConcreteBuilder2 implements Builder{
    private Product product;

    public ConcreteBuilder2() {
        this.product = new Product();
    }

    @Override
    public void buildName() {
        product.setName("222");
    }

    @Override
    public void buildNumber() {
        product.setNumber(2);
    }

    @Override
    public void buildProduceDate() {
        product.setProduceDate(new Date());
    }

    @Override
    public void buildOrigin() {
        product.setOrigin("bbb");
    }

    @Override
    public Product getProduct() {
        return product;
    }
}
