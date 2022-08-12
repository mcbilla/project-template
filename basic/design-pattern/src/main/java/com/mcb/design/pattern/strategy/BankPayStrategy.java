package com.mcb.design.pattern.strategy;

public class BankPayStrategy implements PayStrategy{
    @Override
    public void pay() {
        System.out.println("银联支付");
    }
}
