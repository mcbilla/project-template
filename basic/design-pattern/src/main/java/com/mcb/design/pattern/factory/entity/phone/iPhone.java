package com.mcb.design.pattern.factory.entity.phone;

public class iPhone implements Phone {
    @Override
    public void getPhoneType() {
        System.out.println("iphone");
    }
}
