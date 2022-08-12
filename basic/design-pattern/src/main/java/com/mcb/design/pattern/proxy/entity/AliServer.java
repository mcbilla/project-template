package com.mcb.design.pattern.proxy.entity;

public class AliServer implements Server{
    @Override
    public void run() {
        System.out.println("ali server");
    }
}
