package com.blog.tool.utils;

public class PathUtil {
    public static String systemDomain;
    public static String articleDomain;
    public static String categoryDomain;
    public static String tagDomain;
    public static String centerDomain;

    static{
        PropertiesHelper propertiesHelper= new PropertiesHelper("path_Domain");
        try {
            systemDomain = String.valueOf(propertiesHelper.getProperty("systemDomain"));
            articleDomain = String.valueOf(propertiesHelper.getProperty("articleDomain"));
            categoryDomain = String.valueOf(propertiesHelper.getProperty("categoryDomain"));
            tagDomain = String.valueOf(propertiesHelper.getProperty("tagDomain"));
            centerDomain = String.valueOf(propertiesHelper.getProperty("centerDomain"));
        }catch (Exception e){

        }
    }
}
