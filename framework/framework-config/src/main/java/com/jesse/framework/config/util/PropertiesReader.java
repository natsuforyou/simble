/*
 * ©2016 Jesse. some rights reserved.
 */

package com.jesse.framework.config.util;

import com.jesse.framework.core.utils.PropertiesUtil;
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

    public static String getValue(String path, String key) {
        return PropertiesUtil.getProperties(path).getProperty(key);
    }

    public static String getValue(InputStream inputStream, String key) {
        return PropertiesUtil.getProperties(inputStream).getProperty(key);
    }

    public static String getValue(byte[] buf, String key) {
        return PropertiesUtil.getProperties(buf).getProperty(key);
    }
}
