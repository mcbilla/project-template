package com.mcb.design.pattern.decorator;

public class UserA implements User{
    @Override
    public void goToWork() {
        System.out.println("用户A去上班了");
    }
}
