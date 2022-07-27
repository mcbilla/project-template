package com.mcb.serializable.protostuff;

import org.junit.Test;

import java.util.Arrays;

public class ProtostuffApplicationTests {

    @Test
    public void contextLoads() {
        User user = new User("mcb", 123);
        System.out.println(SerializationUtil.getSchema(User.class));
        byte[] bytes = SerializationUtil.serialize(user);
        System.out.println("原来的对象：" + user);
        System.out.println("序列化后：" + Arrays.toString(bytes));
        System.out.println("反序列化后：" + SerializationUtil.deserialize(bytes, User.class));
    }

}
