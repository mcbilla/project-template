package com.mcb.serializable.protostuff;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 序列化工具
 */
public class SerializationUtil {
    // Protostuff序列化的时候需要用到schema对象，如果每次调用序列化方法和反序列化方法时都需要重新生成一个schema对象有点浪费，把每个类对应的schema对象缓存起来，可以提高序列化和反序列化的速度
    private static final Map<Class<?>, Schema> cachedSchema = new ConcurrentHashMap<>();

    // 通过缓存的方式获取类的schema对象
    public static <T> Schema<T> getSchema(Class<T> cls) {
        Schema<T> schema = (Schema<T>)cachedSchema.get(cls);
        if(schema == null) {
            schema = RuntimeSchema.createFrom(cls);
            cachedSchema.put(cls, schema);
        }
        return schema;
    }

    // 序列化（对象 -> 字节数组）
    public static <T> byte[] serialize(T obj) {
        Class<T> clz = (Class<T>) obj.getClass();
        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
        try {
            Schema<T> schema = getSchema(clz);
            return ProtostuffIOUtil.toByteArray(obj, schema, buffer);
        } catch (Exception e) {
            throw new RuntimeException("serialize fail");
        } finally {
            buffer.clear();
        }
    }

    // 反序列化（字节数组 -> 对象）
    public static <T> T deserialize(byte[] data, Class<T> clz) {
        try {
            Schema<T> schema = getSchema(clz);
            T message = schema.newMessage();
            ProtostuffIOUtil.mergeFrom(data, message, schema);
            return message;
        } catch (Exception e) {
            throw new RuntimeException("deserialize fail");
        }
    }
}
