package com.mcb.design.pattern.template;

public class UserAForBank extends BankTemplate{
    @Override
    protected void business() {
        System.out.println("用户A办理业务");
    }
}
