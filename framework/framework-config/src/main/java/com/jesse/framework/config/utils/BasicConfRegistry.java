/*
 * ©2016 Jesse. some rights reserved.
 */

package com.jesse.framework.config.utils;

import com.jesse.framework.config.constants.ConfConstant;

/**
 * Created by Jesse Qian on 16-5-7.
 * register basic config
 */
public class BasicConfRegistry {

    static String getConfPrefix() {
        return PropertiesReader.getPropertyFromResource(ConfConstant.BASE_CONF_PATH, "conf.prefix");
    }

    static String getIpPath() {
        return PropertiesReader.getPropertyFromResource(ConfConstant.BASE_CONF_PATH, "ip.path");
    }

    public static String getAppName() {
        return PropertiesReader.getPropertyFromResource(ConfConstant.APP_CONF_PATH, "app.name");
    }

    public static String getIp() {
        return PropertiesReader.getProperty(PathResolver.getSolvedIpPath(), "ip");
    }

    public static String getZkConnectString() {
        return PropertiesReader.getProperty(PathResolver.getSolvedZkConfPath(), "connectionString");
    }

    static String getZkConfPrefix() {
        return PropertiesReader.getProperty(PathResolver.getSolvedZkConfPath(), "confPrefix");
    }

    public static boolean isOnlyLocal() {
        String onlyLocal = PropertiesReader.getProperty(PathResolver.getSolvedZkConfPath(), "onlyLocal");
        return Boolean.TRUE.toString().equalsIgnoreCase(onlyLocal);
    }
}
