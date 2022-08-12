package com.mcb.design.pattern.builder;

import java.util.Date;

public class Product {
    private String name;

    private Integer number;

    private Date produceDate;

    private String origin;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getProduceDate() {
        return produceDate;
    }

    public void setProduceDate(Date produceDate) {
        this.produceDate = produceDate;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Product{");
        sb.append("name='").append(name).append('\'');
        sb.append(", number=").append(number);
        sb.append(", produceDate=").append(produceDate);
        sb.append(", origin='").append(origin).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
