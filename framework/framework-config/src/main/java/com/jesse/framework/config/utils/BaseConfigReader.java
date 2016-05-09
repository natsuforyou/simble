/*
 * ©2016 Jesse. some rights reserved.
 */

package com.jesse.framework.config.utils;

/**
 * Created by Jesse Qian on 16-5-7.
 */
public class BaseConfigReader {

    public static String getConfPath(){
        return PropertiesReader.getPropertyFromResource(ConfigPathResolver.getBasePath(), "conf_path");
    }

    public static String getIpPath(){
        return PropertiesReader.getPropertyFromResource(ConfigPathResolver.getBasePath(), "ip_path");
    }

    public static String getIp() {
        return PropertiesReader.getProperty(ConfigPathResolver.getIpPath(), "ip");
    }

    public static boolean isLocal(){
        String local = PropertiesReader.getProperty(ConfigPathResolver.getIpPath(), "local");
        return Boolean.TRUE.toString().equalsIgnoreCase(local);
    }

    public static String getAppName() {
        return PropertiesReader.getPropertyFromResource(ConfigPathResolver.getAppNamePath(), "app.name");
    }

    public static String getZkConnectString(){
        return PropertiesReader.getProperty(ConfigPathResolver.getZkServiceConfPath(), "connectionString");
    }

    public static String getZkConfPath(){
        return PropertiesReader.getProperty(ConfigPathResolver.getZkServiceConfPath(), "zkBasePath");
    }

}
