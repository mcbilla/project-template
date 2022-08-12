package com.mcb.design.pattern.factory.factory3;

import com.mcb.design.pattern.factory.entity.pc.PC;
import com.mcb.design.pattern.factory.entity.phone.Phone;

public interface AbstractFactory {
    Phone makePhone();

    PC makePC();
}
