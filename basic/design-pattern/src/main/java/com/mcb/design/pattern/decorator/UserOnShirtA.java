package com.mcb.design.pattern.decorator;

public class UserOnShirtA extends UserDecrator {
    public UserOnShirtA(User user) {
        super(user);
    }

    @Override
    public void goToWork() {
        System.out.println("穿了ShirtA");
        super.goToWork();
    }
}
