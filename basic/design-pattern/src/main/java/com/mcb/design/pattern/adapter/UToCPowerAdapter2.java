package com.mcb.design.pattern.adapter;

/**
 * 对象适配器
 */
public class UToCPowerAdapter2 implements ChinaPower{
    private USAPower usaPower;

    public UToCPowerAdapter2(USAPower usaPower) {
        this.usaPower = usaPower;
    }

    @Override
    public void charge220V() {
        // 可能要舍弃原来的功能，直接使用成新的功能
//        usaPower.charge110V();
        System.out.println("中国充电220V 对象适配器");
    }
}
