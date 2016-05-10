/*
 * ©2016 Jesse. some rights reserved.
 */

package com.jesse.framework.config.utils;

import java.io.InputStream;

/**
 * Created by Jesse Qian on 16-5-10.
 * read properties by key
 */
public class PropertiesReader {

    public static String getProperty(String filePath, String key) {
        return PropertiesUtil.getProperties(filePath).getProperty(key);
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

    public static String getIp() {
        return getProperty(PropertiesPathResolver.getIpPath(), "ip");
    }

    public static boolean isLocal() {
        String local = getProperty(PropertiesPathResolver.getIpPath(), "local");
        return Boolean.TRUE.toString().equalsIgnoreCase(local);
    }

    public static String getZkConnectString() {
        return getProperty(PropertiesPathResolver.getZkServiceConfPath(), "connectionString");
    }

    public static String getZkConfPath() {
        return getProperty(PropertiesPathResolver.getZkServiceConfPath(), "zkBasePath");
    }
}
