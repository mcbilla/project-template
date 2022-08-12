package com.mcb.design.pattern.factory.factory2;

import com.mcb.design.pattern.factory.entity.phone.MiPhone;
import com.mcb.design.pattern.factory.entity.phone.Phone;

public class MiPhoneFactory implements AbstractFactory{
    @Override
    public Phone makePhone() {
        return new MiPhone();
    }
}
