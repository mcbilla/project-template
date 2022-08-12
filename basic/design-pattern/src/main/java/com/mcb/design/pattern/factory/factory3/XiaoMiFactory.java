package com.mcb.design.pattern.factory.factory3;

import com.mcb.design.pattern.factory.entity.pc.MiPC;
import com.mcb.design.pattern.factory.entity.pc.PC;
import com.mcb.design.pattern.factory.entity.phone.MiPhone;
import com.mcb.design.pattern.factory.entity.phone.Phone;

public class XiaoMiFactory implements AbstractFactory{
    @Override
    public Phone makePhone() {
        return new MiPhone();
    }

    @Override
    public PC makePC() {
        return new MiPC();
    }
}
