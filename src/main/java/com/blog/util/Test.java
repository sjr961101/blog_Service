package com.blog.util;

public class Test {
    public static void main(String[] args) {

        String[] str={"欢乐谷","无限火力","世界之窗","滑冰","减压馆"};
        String value=str[(int)(Math.random()*str.length)];
        System.out.println(value);

    }
}
