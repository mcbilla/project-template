package com.mcb.design.pattern.factory.factory3;

import com.mcb.design.pattern.factory.entity.pc.PC;
import com.mcb.design.pattern.factory.entity.pc.iMac;
import com.mcb.design.pattern.factory.entity.phone.Phone;
import com.mcb.design.pattern.factory.entity.phone.iPhone;

public class AppleFactory implements AbstractFactory{
    @Override
    public Phone makePhone() {
        return new iPhone();
    }

    @Override
    public PC makePC() {
        return new iMac();
    }
}
