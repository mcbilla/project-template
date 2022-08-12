package com.mcb.design.pattern.builder;

/**
 * Builder抽象接口，以规范产品对象的各个组成成分的建造，这个接口只是规范
 */
public interface Builder {
    void buildName();

    void buildNumber();

    void buildProduceDate();

    void buildOrigin();

    Product getProduct();
}
