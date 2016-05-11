/*
 * ©2016 Jesse. some rights reserved.
 */

package com.jesse.framework.config.utils;

import com.jesse.framework.config.constants.ConfConstant;
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
 * resolve file fileName if windows or zookeeper
 */
public class PathResolver {

    private static final Logger logger = LoggerFactory.getLogger(PathResolver.class);

    private static String CONF_PREFIX = BasicConfRegistry.getConfPrefix();
    private static String IP_PATH = BasicConfRegistry.getIpPath();

    private static String getConfPrefix(final ConfLocation location) {
        if (null == location) {
            throw PropertiesException.instance("location must not ne empty");
        }
        if (location == ConfLocation.ZK) {
            return BasicConfRegistry.getZkConfPrefix();
        } else {
            return CONF_PREFIX;
        }
    }

    private static String resolvePathIfWindows(String path) {
        if (SystemUtils.IS_OS_WINDOWS) {
            logger.info("machine environment is windows，original path is:{}", path);
            path = "D:" + path;
            logger.info("machine environment is windows，change path to:{}", path);
        }
        return path;
    }

    static String getSolvedIpPath() {
        return resolvePathIfWindows(IP_PATH);
    }

    static String getSolvedZkConfPath() {
        return getSolvedConfPath(ConfConstant.ZK_CONF_PATH, ConfScope.G, ConfLocation.FS);
    }

    public static String getSolvedConfPath(final String fileName, final ConfScope scope, final ConfLocation location) {
        String separator = File.separator;

        if (StringUtils.isEmpty(fileName) || null == scope || null == location) {
            throw PropertiesException.instance("fileName， scope or location must not be empty");
        }
        if (location == ConfLocation.ZK) {
            separator = "/";
        }
        String appName;
        String confPath = null;
        switch (scope) {
            case G:
                confPath = getConfPrefix(location) + separator + ConfConstant.GLOBAL_STRING + separator + fileName;
                break;
            case P:
                appName = BasicConfRegistry.getAppName();
                confPath = getConfPrefix(location) + separator + appName + separator + fileName;
                break;
        }
        if (location == ConfLocation.FS) {
            confPath = resolvePathIfWindows(confPath);
        }
        logger.info("solve config path successfully, path:{}", confPath);
        return confPath;
    }
}
