package com.mcb.design.pattern.factory.entity.pc;

public class iMac implements PC{
    @Override
    public void getPCType() {
        System.out.println("imac");
    }
}
