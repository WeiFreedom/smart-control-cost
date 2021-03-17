package com.wei.utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BeanUtils {

    /**
     * 复制Bean属性 浅copy
     * @param source
     * @param target
     */
    public static void copyProperties(Object source,Object target){
        org.springframework.beans.BeanUtils.copyProperties(source, target);
    }

    /**
     *  复制bean属性 忽略null 浅copy
     * @param source
     * @param target
     */
    public static void copyPropertiesIgnoreNull(Object source,Object target){
        org.springframework.beans.BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
    }


    /**
     * 获取null值属性名
     *
     * @param source
     * @return
     */
    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet();
        for (PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    /**
     * 将一个对象转化成一个Map对象
     * @param source
     * @return
     */
    public static Map<String,Object> convertMap(Object source){
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Map<String, Object> map = new HashMap<>();
        for(PropertyDescriptor pd : pds){
            Object srcValue = src.getPropertyValue(pd.getName());
            map.put(pd.getName(),srcValue);
        }
        return map;
    }

    /**
     * 根据属性名获取属性的值
     * @param source
     * @param fieldName
     * @return
     */
    public  static Object getFieldValueByFieldName(Object source,String fieldName){
       try {
           Field field = source.getClass().getDeclaredField(fieldName);
           field.setAccessible(true);
           Object result = field.get(source);
           return result;
       }catch (Exception ex){
           return null;
       }
    }

    /**
     * 对象的clone
     * @param source
     * @param <T>
     * @return
     * @throws JsonProcessingException
     */
   public static <T> T clone(T source) {
       ObjectMapper objectMapper = new ObjectMapper();
       try {
           T result = (T) objectMapper.readValue(objectMapper.writeValueAsString(source), source.getClass());
           return result;
       } catch (JsonProcessingException ex){
          return null;
       }
    }
}
