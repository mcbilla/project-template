package com.mcb.design.pattern.template;

public class UserBForBank extends BankTemplate{
    @Override
    protected void business() {
        System.out.println("用户B办理业务");
    }
}
