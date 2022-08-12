package com.mcb.design.pattern.proxy.entity;

public class AwsServer implements Server{
    @Override
    public void run() {
        System.out.println("aws server");
    }
}
