/*
 * ©2016 Jesse. some rights reserved.
 */

package com.jesse.framework.config.utils;

import com.jesse.framework.config.enums.ConfLocation;
import com.jesse.framework.config.enums.ConfScope;
import org.apache.commons.lang3.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Created by Jesse Qian on 16-5-7.
 */
public class ConfigPathResolver {

    private static final Logger logger = LoggerFactory.getLogger(ConfigPathResolver.class);

    private static String CONF_PATH;
    private static String IP_PATH;
    private static String GLOBAL = "global";
    private static String BASE_PATH = "properties/base.properties";
    private static final String ZK_SERVICE_CONF_PATH = "properties/zkService.properties";

    static {
        CONF_PATH = BaseConfigReader.getConfPath();
        IP_PATH = BaseConfigReader.getIpPath();
        logger.info("初始化基础配置：[CONF_PATH:{}], [IP_PATH:{}]", CONF_PATH, IP_PATH);
    }

//    public static String getConfPath() {
//        return resolvePathIfWindows(CONF_PATH);
//    }

    public static String getIpPath() {
        return resolvePathIfWindows(IP_PATH);
    }

    public static String getBasePath(){
        return BASE_PATH;
    }

    public static String getZkServiceConfPath() {
        return resolvePathIfWindows(CONF_PATH + File.separator + GLOBAL + File.separator + ZK_SERVICE_CONF_PATH);
    }

    public static String getConfPath(final String fileName, final ConfScope scope, final ConfLocation location) {
        String separator = File.separator;
        return null;
    }

    private static String resolvePathIfWindows(String path) {
        if (SystemUtils.IS_OS_WINDOWS) {
            logger.info("机器环境为windows，原始路径为：{}", path);
            path = "D:" + path;
            logger.info("机器环境为windows，转换路径为：{}", path);
        }
        return path;
    }
}
