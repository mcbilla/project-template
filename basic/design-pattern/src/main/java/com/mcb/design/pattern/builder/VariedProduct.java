package com.mcb.design.pattern.builder;

import java.util.Date;

/**
 * Builder模式的变种，实现过程如下：
 * 1、在要构建的类内部创建一个静态内部类 Builder，静态内部类的参数与构建类一致
 * 3、构建类的构造函数为私有函数，构造参数是静态内部类，使用静态内部类的变量一一赋值给构建类
 * 4、静态内部类提供参数的 setter 方法，并且返回值是当前 Builder 对象
 * 5、静态内部类最后提供一个 build 方法，构建一个构建类的对象，参数是当前 Builder 对象。
 *
 */
public class VariedProduct {
    private String name;

    private Integer number;

    private Date produceDate;

    private String origin;

    private VariedProduct(Builder builder) {
        this.name = builder.name;
        this.number = builder.number;
        this.produceDate = builder.produceDate;
        this.origin = builder.origin;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String name;

        private Integer number;

        private Date produceDate;

        private String origin;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder number(Integer number) {
            this.number = number;
            return this;
        }

        public Builder produceDate(Date produceDate) {
            this.produceDate = produceDate;
            return this;
        }

        public Builder origin(String origin) {
            this.origin = origin;
            return this;
        }

        public VariedProduct build() {
            return new VariedProduct(this);
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("VariedProduct{");
        sb.append("name='").append(name).append('\'');
        sb.append(", number=").append(number);
        sb.append(", produceDate=").append(produceDate);
        sb.append(", origin='").append(origin).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
