package com.mcb.design.pattern.builder;

import java.util.Date;

/**
 * 建造者模式，将一个复杂的对象的构建与它的表示分离，使得同样的构建过程可以创建不同的方式进行创建。
 *
 * 实现过程：
 * 建造者模式包含的角色：
 * Builder：给出一个抽象接口，以规范产品对象的各个组成成分的建造，其实体类需要实现这些步骤。其会包含一个用来返回最终产品的方法Product getProduct()。
 * ConcreteBuilder：实现Builder接口，针对不同的商业逻辑，具体化复杂对象的各部分的创建。 在建造过程完成后，提供产品的实例。
 * Director：调用具体建造者来创建复杂对象的各个部分，在指导者中不涉及具体产品的信息，只负责保证对象各部分完整创建或按某种顺序创建。其会包含一个负责组装的方法void Construct(Builder builder)， 在这个方法中通过调用builder的方法，就可以设置builder，等设置完成后，就可以通过builder的 getProduct() 方法获得最终的产品。
 * Product：要创建的复杂对象。
 *
 * 应用场景：
 * 1、需要生成的对象具有复杂的内部结构。当一个类的构造函数参数个数超过4个，而且这些参数有些是可选的参数，考虑使用构造者模式。
 * 2、需要生成的对象内部属性本身相互依赖。
 *
 * 建造者模式和工厂模式的区别：
 * 建造者模式：创建单个类的产品，更加关注与零件装配的顺序。
 * 工厂模式：将各种产品集中起来进行管理，用来具有不同种类的产品。
 */
public class Main {
    public static void main(String[] args) {
        // director只用来指导生产顺序
        Director director = new Director();

        // 生产产品1
        Product product1 = director.produceProduct(new ConcreteBuilder1());
        System.out.println(product1.toString());

        // 生产产品2
        Product product2 = director.produceProduct(new ConcreteBuilder2());
        System.out.println(product2.toString());

        // 变种builder模式，也是日常开发最常使用的模式
        VariedProduct product3 = VariedProduct.builder()
                .name("333")
                .number(3)
                .produceDate(new Date())
                .origin("ccc")
                .build();
        System.out.println(product3.toString());
    }
}
