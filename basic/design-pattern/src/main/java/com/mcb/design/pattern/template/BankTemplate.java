package com.mcb.design.pattern.template;

public abstract class BankTemplate {
    /**
     * 取号
     */
    private void takeNumber() {
        System.out.println("取号");
    }

    /**
     * 办理业务
     */
    protected abstract void business();

    /**
     * 评价
     */
    private void appraise() {
        System.out.println("评价");
    }

    /**
     * 定义模板流程
     */
    public final void routineFlow() {
        takeNumber();
        business();
        appraise();
    }
}
