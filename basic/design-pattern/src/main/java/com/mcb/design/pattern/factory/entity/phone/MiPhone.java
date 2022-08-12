package com.mcb.design.pattern.factory.entity.phone;

public class MiPhone implements Phone {
    @Override
    public void getPhoneType() {
        System.out.println("xiaomi phone");
    }
}
