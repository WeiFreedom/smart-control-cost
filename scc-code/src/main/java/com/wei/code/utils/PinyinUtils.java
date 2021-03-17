package com.wei.code.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PinyinUtils {

    /**
     *  获取汉字首字母或全拼大写字母
     *
     * @param chinese 汉字
     * @param isFull  是否全拼 true:表示全拼 false表示：首字母
     *
     * @return 全拼或者首字母大写字符窜
     */
    public static String getUpperCase(String chinese,boolean isFull){
        return convertHanzi2Pinyin(chinese,isFull,"").toUpperCase();
    }


    /**
     * 获取汉字首字母或全拼小写字母
     *
     * @param chinese 汉字
     * @param isFull 是否全拼 true:表示全拼 false表示：首字母
     *
     * @return 全拼或者首字母小写字符窜
     */
    public static  String getLowerCase(String chinese,boolean isFull,String splitStr){
        if (org.apache.commons.lang3.StringUtils.isEmpty(splitStr)){
            return convertHanzi2Pinyin(chinese,isFull,"").toLowerCase();
        }else {
            return convertHanzi2Pinyin(chinese,isFull,splitStr).toLowerCase();
        }
    }
    /**
     * 获取汉字首字母或全拼大写字母
     *
     * @param chinese 汉字
     * @param isFull 是否全拼 true:表示全拼 false表示：首字母
     *
     * @return 全拼或者首字母大写字符窜
     */
    public static  String getUpperCase(String chinese,boolean isFull,String splitStr){
        if (org.apache.commons.lang3.StringUtils.isEmpty(splitStr)){
            return convertHanzi2Pinyin(chinese,isFull,"").toUpperCase();
        }else {
            return convertHanzi2Pinyin(chinese,isFull,splitStr).toUpperCase();
        }
    }

    /**
     * 将汉字转成拼音
     * <P>
     * 取首字母或全拼
     *
     * @param hanzi 汉字字符串
     * @param isFull 是否全拼 true:表示全拼 false表示：首字母
     *
     * @return 拼音
     */
    public static String convertHanzi2Pinyin(String hanzi,boolean isFull,String splitStr){
        /***
         * ^[\u2E80-\u9FFF]+$ 匹配所有东亚区的语言
         * ^[\u4E00-\u9FFF]+$ 匹配简体和繁体
         * ^[\u4E00-\u9FA5]+$ 匹配简体
         */
        String regExp="^[\u4E00-\u9FFF]+$";
        StringBuffer sb=new StringBuffer();
        if(hanzi==null||"".equals(hanzi.trim())){
            return "";
        }
        String pinyin="";
        int length = hanzi.length();
        int splitStrLength = splitStr.length();
        for(int i = 0; i< length; i++){
            char unit=hanzi.charAt(i);
            //是汉字，则转拼音
            if(match(String.valueOf(unit),regExp)){
                pinyin=convertSingleHanzi2Pinyin(unit);
                // 补充汉字字符拼音前面缺少的 分割字符串
                if (sb.lastIndexOf(splitStr) > -1 && !sb.substring(sb.length()-splitStrLength).toString().equals(splitStr)){
                    sb.append(splitStr);
                }
                if(isFull){
                    sb.append(pinyin);
                }
                else{
                    sb.append(pinyin.charAt(0));
                }
                // 填充汉字字符拼音后的 分割字符串
                if (i< length-1){
                    sb.append(splitStr);
                }
            }else{
                sb.append(unit);
            }
        }
        return sb.toString();
    }

    /**
     * 将单个汉字转成拼音
     *
     * @param hanzi 汉字字符
     *
     * @return 拼音
     */
    private static String convertSingleHanzi2Pinyin(char hanzi){
        HanyuPinyinOutputFormat outputFormat = new HanyuPinyinOutputFormat();
        outputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        String[] res;
        StringBuffer sb=new StringBuffer();
        try {
            res = PinyinHelper.toHanyuPinyinStringArray(hanzi,outputFormat);
            sb.append(res[0]);//对于多音字，只用第一个拼音
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        return sb.toString();
    }
    public static String convertHanzi2Pinyin(String hanzi){
        return convertHanzi2Pinyin(hanzi,true," ");
    }
    /***
     * 匹配
     * <P>
     * 根据字符和正则表达式进行匹配
     *
     * @param str 源字符串
     * @param regex 正则表达式
     *
     * @return true：匹配成功  false：匹配失败
     */
    private static boolean match(String str,String regex){
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(str);
        return matcher.find();
    }
}
