package com.blog.util;


import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

/**
    * @Description:
    * @Author: 沈俊仁
    * @Date: 2020/1/1
*/
public class TimeUtil {
    
    /**
     * @Description 时间转字符串
     * @param format 时间格式
     * @param time 转换时间
     * @return java.lang.String
    */
    public static String timeToStr(String format, Date time){
        String timeStr =null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try{
            timeStr = sdf.format(time);
        }catch (Exception e){
            e.printStackTrace();
        }
        return timeStr;
    }

    /**
     * @Description 时间转字符串
     * @param time 转换时间
     * @return java.lang.String
     */
    public static String timeToStr(Date time){
        String timeStr =null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try{
            timeStr = sdf.format(time);
        }catch (Exception e){
            e.printStackTrace();
        }
        return timeStr;
    }

    /**
     * @Description //TODO
     * @param format 时间格式
     * @param time  转换时间
     * @return java.util.Date
    */
    public static Date strToTime(String format, String time){
        Date timeDate =null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            timeDate = sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
       }
        return timeDate;
    }

    /**
     * @Description //TODO
     * @param time  转换时间
     * @return java.util.Date
     */
    public static Date strToTime(String time){
        Date timeDate =null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            timeDate = sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timeDate;
    }
}
