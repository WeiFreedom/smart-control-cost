package com.wei.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtils {

    private DateTimeUtils(){}

    public final static String DATE_FORMAT = "yyyy-MM-dd";
    public final static String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public final static String TIME_FORMAT = "HH:mm:ss";
    public final static String MONTH_FORMAT = "yyyy-MM";
    public final static String YEAR_FORMAT = "yyyy";

    /**
     * 创建Calendar对象，时间为默认时区的当前时间
     *
     * @return Calendar对象
     * @since 4.6.6
     */
    public static Calendar calendar() {
        return Calendar.getInstance();
    }

    /**
     * Calendar 转 Date
     * @param calendar
     * @return
     */
    public static Date calendarToDate(Calendar calendar){
        return calendar.getTime();
    }

    /**
     * Date 转 Calendar
     * @param date
     * @return
     */
    public static Calendar dateToCalendar(Date date){
        Calendar calendar = calendar();
        calendar.setTime(date);
        return calendar;
    }
    /**
     * 格式化时间
     * @param date 传入的时间
     * @param pattern 格式
     * @return
     */
    public static String format(Date date,String pattern){
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        return df.format(date);
    }

    /**
     * 加多天
     * @param date
     * @param days
     * @return
     */
    public static Date addDates(Date date,int days){
        Calendar calendar = dateToCalendar(date);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        return calendarToDate(calendar);
    }

    /**
     * 加多月
     * @param date
     * @param month
     * @return
     */
    public static Date addMonths(Date date,int month){
        Calendar calendar = dateToCalendar(date);
        calendar.add(Calendar.MONTH, month);
        return calendarToDate(calendar);
    }

    /**
     * 加多年
     * @param date
     * @param year
     * @return
     */
    public static Date addYears(Date date,int year){
        Calendar calendar = dateToCalendar(date);
        calendar.add(Calendar.YEAR, year);
        return calendarToDate(calendar);
    }

    /**
     * 获取当前时间
     * @return
     */
    public static Date now(){
        return new Date();
    }

    /**
     * 字符串转换成日期
     * @param date
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static Date convert(String date,String pattern) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        return df.parse(date);
    }
}
