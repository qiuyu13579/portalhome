package com.ai.portalhome.test.util;

import java.lang.reflect.Field;

public class ReflectUtil {
    
    /**
     * 通过反射给对象的属性赋值
     * @param srcObject 要赋值的对象
     * @param fieldName 赋值的属性名称
     * @param value 值
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @author liangyi
     */
    public static void setValue(Object srcObject,String fieldName,Object value) throws IllegalArgumentException, IllegalAccessException{
        if (srcObject==null||fieldName==null) {
            return;
        }
        
        Class<?> clazz = srcObject.getClass();  
        Field[] fields = clazz.getDeclaredFields(); 
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            if (fieldName.equals(fields[i].getName())) {
                fields[i].set(srcObject, value);
                break;
            }
        }  
    }

}
