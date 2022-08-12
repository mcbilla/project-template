package com.mcb.design.pattern.adapter;

/**
 * 类适配器
 */
public class UToCPowerAdapter1 extends USAPowerImpl implements ChinaPower{
    @Override
    public void charge220V() {
        // 可能要舍弃原来的功能，直接使用成新的功能
//        super.charge110V();
        System.out.println("中国充电220V 类适配器");
    }
}
