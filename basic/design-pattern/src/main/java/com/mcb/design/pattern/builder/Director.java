package com.mcb.design.pattern.builder;

/**
 * 调用具体建造者来创建复杂对象的各个部分，在指导者中不涉及具体产品的信息，只负责保证对象各部分完整创建或按某种顺序创建
 */
public class Director {
    public Product produceProduct(Builder builder) {
        builder.buildName();
        builder.buildNumber();
        builder.buildOrigin();
        builder.buildProduceDate();
        return builder.getProduct();
    }
}
