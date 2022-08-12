package com.mcb.design.pattern.decorator;

/**
 * 装饰器，一般为抽象类
 */
public abstract class UserDecrator implements User{

    private User user;

    public UserDecrator(User user) {
        this.user = user;
    }

    @Override
    public void goToWork() {
        user.goToWork();
    }
}
