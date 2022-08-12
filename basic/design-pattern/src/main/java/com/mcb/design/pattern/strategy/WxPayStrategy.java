package com.mcb.design.pattern.strategy;

public class WxPayStrategy implements PayStrategy{
    @Override
    public void pay() {
        System.out.println("微信支付");
    }
}
