package com.mcb.design.pattern.factory.factory2;

import com.mcb.design.pattern.factory.entity.phone.Phone;
import com.mcb.design.pattern.factory.entity.phone.iPhone;

public class iPhoneFactory implements AbstractFactory{
    @Override
    public Phone makePhone() {
        return new iPhone();
    }
}
