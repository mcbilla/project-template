package com.mcb.design.pattern.factory.factory2;

import com.mcb.design.pattern.factory.entity.phone.HuaweiPhone;
import com.mcb.design.pattern.factory.entity.phone.Phone;

public class HuaweiPhoneFactory implements AbstractFactory{
    @Override
    public Phone makePhone() {
        return new HuaweiPhone();
    }
}
