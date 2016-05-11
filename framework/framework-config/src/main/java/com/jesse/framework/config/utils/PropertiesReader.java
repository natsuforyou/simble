/*
 * ©2016 Jesse. some rights reserved.
 */

package com.jesse.framework.config.utils;

/**
 * Created by Jesse Qian on 16-5-10.
 * read properties by key
 */
class PropertiesReader {

    public static String getProperty(String filePath, String key) {
        return PropertiesUtil.getProperties(filePath).getProperty(key);
    }

    static String getPropertyFromResource(String classpath, String key) {
        return PropertiesUtil.getPropertiesFromResource(classpath).getProperty(key);
    }

    public static String getProperty(byte[] buf, String key) {
        return PropertiesUtil.getProperties(buf).getProperty(key);
    }


}
