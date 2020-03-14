package com.blog.tool.utils;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesHelper {

    private static Object obj = new Object();
    Properties properties;

    public PropertiesHelper(String fileName){
        synchronized (obj){
            if(fileName != null && fileName.length()>0){
                fileName += ".properties";
                try{
                    InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
                    properties = new Properties();
                    properties.load(resourceAsStream);
                    resourceAsStream.close();
                }catch (Exception e){

                }
            }
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

}
