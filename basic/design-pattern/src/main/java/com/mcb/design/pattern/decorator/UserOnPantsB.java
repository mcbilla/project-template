package com.mcb.design.pattern.decorator;

public class UserOnPantsB extends UserDecrator{
    public UserOnPantsB(User user) {
        super(user);
    }

    @Override
    public void goToWork() {
        System.out.println("穿了PantsB");
        super.goToWork();
    }
}
