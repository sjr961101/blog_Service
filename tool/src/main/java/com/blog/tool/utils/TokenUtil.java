package com.blog.tool.utils;

import java.util.Date;

public class TokenUtil {
    /**
     * @Description 获取token
     * @param userName
     * @return java.lang.String
    */
    public static String produceToken(String userName){
        StringBuilder token= new StringBuilder();
        token.append(userName);
        token.append(TimeUtil.timeToStr("YYYYMMDDHHmmss",new Date()));
        token.append((char)(Math.random()*26+65));
        token.append((int)(Math.random()*99));
        return token.toString();
    }

//    public static void main(String[] args){
//        String s=TokenUtil.produceToken("main");
//        System.out.println(s);
//    }
}
