package com.atguigu.springcloud.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author zhqin.zhou
 * @date 2021/11/1 16:01
 * @description JSONUtils
 */
@Slf4j
public class JSONUtils {

    private static ObjectMapper mapper = new ObjectMapper();

    /**
     * 解析JSON对象中包含数组
     * @param JOSNStr
     * @param t
     * @param <T>
     * @return
     * @throws NoSuchFieldException
     * @throws IOException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static <T> T resolverObjectIncludeArrayByJSON(String JOSNStr, Class<T> t) throws NoSuchFieldException, IOException, IllegalAccessException, InstantiationException {
        // 将JSON字符串转换成JsonNode格式
        JsonNode jsonNode = mapper.readTree(JOSNStr);
        Iterator<Map.Entry<String, JsonNode>> elements = jsonNode.fields();
        // 实例化返回对象
        T clazz = t.newInstance();
        // 遍历JSONNode节点数据
        while(elements.hasNext()) {
            Map.Entry<String, JsonNode> node = elements.next();
            // 获取当前节点的key值
            String key = node.getKey();
            // 反射传入转换对象的key值对应的属性
            boolean exist = false;
            Field[] fields= t.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                if(fields[i].getName().equals(key))
                {
                    exist = true;
                    break;
                }
            }
            if(exist){
                Field field = clazz.getClass().getDeclaredField(key);
                field.setAccessible(true);
                // 获取当前key值对应的类
                Class<?> cls = t.getDeclaredField(key).getType();
                // 判断是否为集合对象
                if(StringUtils.equals(cls.getName(), "java.util.List")) {
                    ParameterizedType p = (ParameterizedType)t.getDeclaredField(key).getGenericType();
                    Class c = (Class)p.getActualTypeArguments()[0];
                    // 集合对象只用Array进行实例化
                    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                    String jsonPase = node.getValue().toString();
                    if(StringUtils.equals(jsonPase.substring(0, 1), "{") && StringUtils.equals(jsonPase.substring(jsonPase.length() - 1), "}")){
                        jsonPase = "[" + jsonPase + "]";
                    }
                    Object array = mapper.readValue(jsonPase, Array.newInstance(c, 1).getClass());
                    // 遍历Array，并且set到返回对象对应的属性中
                    if(array != null && Array.getLength(array) > 0) {
                        List list = new ArrayList();
                        for(int i = 0; i < Array.getLength(array); i++){
                            list.add(Array.get(array, i));
                        }
                        field.set(clazz, list);
                    }
                } else {
                    // 转换的对象set到返回对象的属性中
                    Object obj = mapper.readValue(node.getValue().toString(), cls);
                    field.set(clazz, obj);
                }
            } else {
                log.error("JSON转换对象属性[{}]不存在跳过转换", key);
            }

        }
        return clazz;
    }
}

