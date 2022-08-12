package com.mcb.design.pattern.strategy;

public class AliPayStrategy implements PayStrategy{
    @Override
    public void pay() {
        System.out.println("支付宝支付");
    }
}
