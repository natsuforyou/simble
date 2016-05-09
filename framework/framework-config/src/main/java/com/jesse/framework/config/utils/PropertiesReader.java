/*
 * ©2016 Jesse. some rights reserved.
 */

package com.jesse.framework.config.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

/**
 * Created by Jesse Qian on 16-5-6.
 * {@link PropertiesUtil}
 * 配置读取工具类
 */
public class PropertiesReader {
    private static Logger logger = LoggerFactory.getLogger(PropertiesReader.class);

    public static String getProperty(String path, String key) {
        return PropertiesUtil.getProperties(path).getProperty(key);
    }

    public static String getProperty(InputStream inputStream, String key) {
        return PropertiesUtil.getProperties(inputStream).getProperty(key);
    }

    public static String getPropertyFromResource(String classpath, String key) {
        return PropertiesUtil.getPropertiesFromResource(classpath).getProperty(key);
    }

    public static String getProperty(byte[] buf, String key) {
        return PropertiesUtil.getProperties(buf).getProperty(key);
    }
}
