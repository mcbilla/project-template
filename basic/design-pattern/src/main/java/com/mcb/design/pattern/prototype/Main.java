package com.mcb.design.pattern.prototype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * 原型模式，用于创建重复的对象，同时又能保证性能。当直接创建对象的代价比较大时，则采用这种模式。
 *
 * 实现：
 * 1、实现Cloneable接口。在java语言有一个Cloneable接口，它的作用只有一个，就是在运行时通知虚拟机可以安全地在实现了此接口的类上使用clone方法。在java虚拟机中，只有实现了这个接口的类才可以被拷贝，否则在运行时会抛出CloneNotSupportedException异常。
 * 2、重写Object类中的clone方法。Java中，所有类的父类都是Object类，Object类中有一个clone方法，作用是返回对象的一个拷贝，但是其作用域protected类型的，一般的类无法调用，因此Prototype类需要将clone方法的作用域修改为public类型。
 *
 * 应用场景：
 * 1、类初始化需要消化非常多的资源，这个资源包括数据、硬件资源等。这时我们就可以通过原型拷贝避免这些消耗。很多软件提供的复制(Ctrl + C)和粘贴(Ctrl + V)操作就是原型模式的典型应用
 * 2、通过new产生的一个对象需要非常繁琐的数据准备或者权限，这时可以使用原型模式。
 * 3、一个对象需要提供给其他对象访问，而且各个调用者可能都需要修改其值时，可以考虑使用原型模式拷贝多个对象供调用者使用，即保护性拷贝。
 *
 * 优点：
 * 1、当创建新的对象实例较为复杂时，使用原型模式可以简化对象的创建过程，通过复制一个已有实例可以提高新实例的创建效率。
 * 2、可以使用深克隆的方式保存对象的状态，使用原型模式将对象复制一份并将其状态保存起来，以便在需要的时候使用（如恢复到某一历史状态），可辅助实现撤销操作。
 *
 * 缺点：
 * 1、需要为每一个类配备一个克隆方法，而且该克隆方法位于一个类的内部，当对已有的类进行改造时，需要修改源代码，违背了“开闭原则”。
 * 2、在实现深克隆时需要编写较为复杂的代码，而且当对象之间存在多重的嵌套引用时，为了实现深克隆，每一层对象对应的类都必须支持深克隆，实现起来可能会比较麻烦。
 *
 * 深复制和浅复制的区别：
 * 浅复制：只是拷贝了基本类型的数据，而引用类型数据，只是拷贝了一份引用地址。默认为浅拷贝。
 * 深复制：在计算机中开辟了一块新的内存地址用于存放复制的对象，除了对象本身被复制外，对象所包含的所有成员变量也将复制
 *
 * 示例：
 * 假设平时我们都要记笔记，自然有一些固定的格式，那我们是不是就没有必要辛辛苦苦写格式，是不是就可以直接将写好的当成模板进行修改呢。
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        DiaryTemplate dairy1 = new DiaryTemplate("mcb", new Date(), new ArrayList<>(Arrays.asList("123", "456")));
        DiaryTemplate dairy2 = (DiaryTemplate) dairy1.clone();
        System.out.println(dairy1);
        System.out.println(dairy2);
        // 结果为false，说明是两个不同的对象
        System.out.println(dairy1 == dairy2);
        // 如果是浅复制，结果为true。如果是深复制，结果为false
        System.out.println(dairy1.getContent() == dairy2.getContent());
    }
}
