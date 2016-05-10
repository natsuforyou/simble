/*
 * ©2016 Jesse. some rights reserved.
 */

package com.jesse.framework.config.utils;

import com.jesse.framework.config.enums.ConfLocation;
import com.jesse.framework.config.enums.ConfScope;
import com.jesse.framework.config.exception.PropertiesException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Created by Jesse Qian on 16-5-7.
 */
public class PropertiesPathResolver {

    private static final Logger logger = LoggerFactory.getLogger(PropertiesPathResolver.class);

    private static String CONF_PATH;
    private static String IP_PATH;
    private static final String GLOBAL = "global";
    private static final String BASE_PATH = "properties/basicConfig.properties";
    private static final String APP_NAME_PATH = "META-INF/app.properties";
    private static final String ZK_SERVICE_CONF_PATH = "properties/zkService.properties";

    static {
        CONF_PATH = BasicConfReader.getConfPath();
        IP_PATH = BasicConfReader.getIpPath();
        logger.info("初始化基础配置：[CONF_PATH:{}], [IP_PATH:{}]", CONF_PATH, IP_PATH);
    }

    public static String getConfPath() {
        return resolvePathIfWindows(CONF_PATH);
    }

    public static String getIpPath() {
        return resolvePathIfWindows(IP_PATH);
    }

    public static String getBasePath() {
        return BASE_PATH;
    }

    public static String getAppNamePath() {
        return APP_NAME_PATH;
    }

    public static String getZkServiceConfPath() {
        return resolvePathIfWindows(CONF_PATH + File.separator + GLOBAL + File.separator + ZK_SERVICE_CONF_PATH);
    }

    private static String getBaseConfPath(final ConfLocation location) {
        if (null == location) {
            throw PropertiesException.instance("");
        }
        if (location == ConfLocation.ZK) {
            return PropertiesReader.getZkConfPath();
        } else {
            return getConfPath();
        }
    }

    public static String getConfPath(final String path, final ConfScope scope, final ConfLocation location) {
        String separator = File.separator;
        if (location == ConfLocation.ZK) {
            separator = "/";
        }
        if (StringUtils.isEmpty(path) || null == scope) {
            throw PropertiesException.instance("");
        }
        String appName;
        String confPath = null;
        switch (scope) {
            case G:
                confPath = getBaseConfPath(location) + separator + GLOBAL + separator + path;
                break;
            case P:
                appName = BasicConfReader.getAppName();
                confPath = getBaseConfPath(location) + separator + appName + separator + path;
                break;
        }
        logger.info("");
        return confPath;
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
