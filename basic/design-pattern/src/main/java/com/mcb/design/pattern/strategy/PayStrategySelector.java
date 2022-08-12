package com.mcb.design.pattern.strategy;

/**
 * 策略选择器，提供统一对象给客户端调用
 */
public class PayStrategySelector {
    // 注入选择的策略
    private PayStrategy payStrategy;

    public PayStrategySelector(PayStrategy payStrategy) {
        this.payStrategy = payStrategy;
    }

    public PayStrategy getPayStrategy() {
        return payStrategy;
    }

    public void setPayStrategy(PayStrategy payStrategy) {
        this.payStrategy = payStrategy;
    }

    /**
     * 调用注入策略
     */
    public void selectPay() {
        payStrategy.pay();
    }
}
