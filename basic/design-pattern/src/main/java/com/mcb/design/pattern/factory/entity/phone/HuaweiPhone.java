package com.mcb.design.pattern.factory.entity.phone;

public class HuaweiPhone implements Phone {
    @Override
    public void getPhoneType() {
        System.out.println("huawei phone");
    }
}
