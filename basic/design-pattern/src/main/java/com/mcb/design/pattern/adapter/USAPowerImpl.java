package com.mcb.design.pattern.adapter;

public class USAPowerImpl implements USAPower{
    @Override
    public void charge110V() {
        System.out.println("美国充电110V");
    }
}
