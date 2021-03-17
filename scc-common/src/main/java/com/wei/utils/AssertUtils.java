package com.wei.utils;

import com.wei.utils.exception.ValidatorException;

public final class AssertUtils {
    /**
     * 判断对象是否为空
     * @param object
     * @param message
     */
    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new ValidatorException(message);
        }
    }

    /**
     * 判断对象是否是空
     * @param object
     * @param format
     * @param params
     */
    public static void notNull(Object object, String format, Object... params) {
        if (object == null) {
            throw new ValidatorException(StringUtils.format(format,params));
        }
    }

    /**
     * 判断字符串是否为空
     * @param str
     * @param message
     */
    public static void notEmpty(String str,String message){
        if(StringUtils.isEmpty(str)){
            throw new ValidatorException(message);
        }
    }
}
