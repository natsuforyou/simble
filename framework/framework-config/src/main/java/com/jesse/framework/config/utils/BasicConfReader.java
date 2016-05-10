/*
 * ©2016 Jesse. some rights reserved.
 */

package com.jesse.framework.config.utils;

/**
 * Created by Jesse Qian on 16-5-7.
 * read basic config from classpath
 */
public class BasicConfReader {

    public static String getConfPath() {
        return PropertiesReader.getPropertyFromResource(PropertiesPathResolver.getBasePath(), "conf.path");
    }

    public static String getIpPath() {
        return PropertiesReader.getPropertyFromResource(PropertiesPathResolver.getBasePath(), "ip.path");
    }

    public static String getAppName() {
        return PropertiesReader.getPropertyFromResource(PropertiesPathResolver.getAppNamePath(), "app.name");
    }

}
