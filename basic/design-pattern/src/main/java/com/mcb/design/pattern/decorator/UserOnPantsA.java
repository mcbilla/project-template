package com.mcb.design.pattern.decorator;

public class UserOnPantsA extends UserDecrator{
    public UserOnPantsA(User user) {
        super(user);
    }

    @Override
    public void goToWork() {
        System.out.println("穿了PantsA");
        super.goToWork();
    }
}
