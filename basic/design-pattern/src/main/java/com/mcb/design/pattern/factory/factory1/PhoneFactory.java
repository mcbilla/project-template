package com.mcb.design.pattern.factory.factory1;

import com.mcb.design.pattern.factory.entity.phone.HuaweiPhone;
import com.mcb.design.pattern.factory.entity.phone.MiPhone;
import com.mcb.design.pattern.factory.entity.phone.Phone;
import com.mcb.design.pattern.factory.entity.phone.iPhone;

public class PhoneFactory {
    public static Phone getPhone(String name) {
        if (name.equalsIgnoreCase("iPhone")) {
            return new iPhone();
        } else if (name.equalsIgnoreCase("MiPhone")) {
            return new MiPhone();
        } else if (name.equalsIgnoreCase("HuaweiPhone")) {
            return new HuaweiPhone();
        } else {
            return null;
        }
    }
}
