package com.mcb.design.pattern.strategy;

/**
 * 策略模式，定义了一系列算法，分别封装起来，让它们之间可相互替换，此模式让算法的变化独立于使用算法的客户。
 *
 * 优点：
 * 1、算法可以自由切换。 2、避免使用多重条件判断。 3、扩展性非常良好。
 *
 * 缺点：
 * 1、策略类会增多。 2、所有策略类都需要对外暴露。
 *
 * 应用场景：
 * 1、一个类定义了多种行为，并且这些行为在这个类的操作中以多个条件语句的形式出现，可将每个条件分支移入它们各自的策略类中以代替这些条件语句，可以减少大量的if/else语句。
 * 2、系统中各算法彼此完全独立，且要求对客户隐藏具体算法的实现细节时。
 *
 * 示例：
 * 假如我们有微信支付、支付宝支付、银联支付三种支付方式，可以自由选择支付方式。
 */
public class Main {
    public static void main(String[] args) {
        // 使用同一个策略选择器，注入不同的策略，就可以实现调用不同的策略方法
        PayStrategySelector payStrategySelector = new PayStrategySelector(new WxPayStrategy());
        payStrategySelector.selectPay();

        payStrategySelector.setPayStrategy(new AliPayStrategy());
        payStrategySelector.selectPay();

        payStrategySelector.setPayStrategy(new BankPayStrategy());
        payStrategySelector.selectPay();
    }
}
