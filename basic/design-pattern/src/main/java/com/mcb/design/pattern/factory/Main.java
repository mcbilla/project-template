package com.mcb.design.pattern.factory;

import com.mcb.design.pattern.factory.entity.pc.PC;
import com.mcb.design.pattern.factory.entity.phone.Phone;
import com.mcb.design.pattern.factory.factory1.PhoneFactory;
import com.mcb.design.pattern.factory.factory2.MiPhoneFactory;
import com.mcb.design.pattern.factory.factory2.iPhoneFactory;
import com.mcb.design.pattern.factory.factory3.AppleFactory;
import com.mcb.design.pattern.factory.factory3.XiaoMiFactory;

/**
 * 工厂模式，是用来创建产品的模式，我们在创建对象时不会对客户端暴露创建逻辑，并且是通过使用一个共同的接口来指向新创建的对象。实现了创建者和调用者分离。
 * <p>
 * 优点：
 * 利用工厂模式可以降低程序的耦合性，为后期的维护修改提供了很大的便利。
 * 将选择实现类、创建对象统一管理和控制。从而将调用者跟我们的实现类解耦。
 * <p>
 * 工厂模式的类型：
 * 简单工厂：生产同一等级结构中的任意产品，不支持拓展增加产品。该模式在工厂里面对不同类对象的创建进行了一层薄薄的封装，然后通过向工厂传递类型来指定要创建的对象。
 * 工厂方法：生产同一等级结构中的固定产品，支持拓展增加产品。和简单工厂模式中工厂负责生产所有产品相比，工厂方法模式不生产产品，定义一个抽象工厂，其定义了产品的生产接口，但不负责具体的产品，将生产任务交给不同的派生类工厂。
 * 抽象工厂：生产不同产品族的全部产品，不支持拓展增加产品，支持增加产品族。抽象工厂可以创建具体工厂，但和工厂方法的具体工厂不同，抽象工厂的某一具体工厂可以生产该种类下的所有产品，而工厂方法的具体工厂只能生产该种类下的单一产品。
 *
 * 示例：
 * 假如有接口Phone和旗下子类iPhone、MiPhone和HuaweiPhone，还有另外一个接口PC和旗下子类iMac和MiPC
 * 我们想在main方法里面不调用子类的构造函数就可以获取对应类型的对象
 */
public class Main {
    public static void main(String[] args) {
        // 简单工厂，只需要传入产品名称就可以创建产品
        Phone miPhone = PhoneFactory.getPhone("MiPhone");
        miPhone.getPhoneType();
        Phone iphone = PhoneFactory.getPhone("iPhone");
        iphone.getPhoneType();

        // 工厂方法，每种产品都有专属的工厂
        Phone miPhone1 = new MiPhoneFactory().makePhone();
        miPhone1.getPhoneType();
        Phone iPhone1 = new iPhoneFactory().makePhone();
        iPhone1.getPhoneType();

        // 抽象工厂，每类产品有专属的工厂，该工厂可以创建该类下面的所有产品
        PC miPC = new XiaoMiFactory().makePC();
        miPC.getPCType();
        PC iMac = new AppleFactory().makePC();
        iMac.getPCType();
    }
}
