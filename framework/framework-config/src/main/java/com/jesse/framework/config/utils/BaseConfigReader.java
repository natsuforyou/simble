/*
 * ©2016 Jesse. some rights reserved.
 */

package com.jesse.framework.config.utils;

import java.io.File;

/**
 * Created by Jesse Qian on 16-5-7.
 */
public class BaseConfigReader {

    private static String CONF_PATH;
    private static String IP_PATH;
    private static String GLOBAL = "global";
    private static final String ZK_SERVICE_CONF_PATH = "properties/zkService.properties";

    static {
        CONF_PATH = "/opt/conf/data";
        IP_PATH = "/data/etc/local/ip";
//        if (SystemUtils.IS_OS_WINDOWS) {
//            CONF_PATH = "D:" + CONF_PATH.replace("/", "\\");
//            IP_PATH = "D:" + IP_PATH.replace("/", "\\");
//        }
    }

    public static String getConfPath() {
        return CONF_PATH;
    }

    private static String getIpPath() {
        return IP_PATH;
    }

    private static String getZkServiceConfPath() {
        return CONF_PATH + File.separator + GLOBAL + File.separator + ZK_SERVICE_CONF_PATH;
    }


    public static String getIp() {
        return PropertiesReader.getValue(getIpPath(), "ip");
    }

    public static boolean isLocal(){
        String local = PropertiesReader.getValue(getIpPath(), "local");
        return Boolean.TRUE.toString().equalsIgnoreCase(local);
    }

    public static String getZkConnectString(){
        return PropertiesReader.getValue(getZkServiceConfPath(), "connectionString");
    }

    public static String getZkConfPath(){
        return PropertiesReader.getValue(getZkServiceConfPath(), "zkBasePath");
    }
}
