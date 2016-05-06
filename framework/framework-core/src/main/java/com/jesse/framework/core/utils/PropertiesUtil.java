/*
 * ©2016 Jesse. some rights reserved.
 */

package com.jesse.framework.core.utils;

import com.jesse.framework.core.exception.PropertiesException;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.*;
import java.util.Properties;

/**
 * Created by Jesse Qian on 16-5-6.
 * 配置文件读取工具类
 */
public class PropertiesUtil {

    private static Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

    public static Properties getProperties(String path) {
        if (StringUtils.isBlank(path)) {
            logger.error("指定文件系统路径为空");
            throw PropertiesException.instance("指定文件系统路径为空");
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"))) {
            Properties properties = new Properties();
            properties.load(reader);
            logger.info("读取指定文件系统路径配置成功", properties);
            return properties;
        } catch (IOException e) {
            logger.error("无法从指定文件系统路径读取配置");
            throw PropertiesException.instance("无法从指定文件系统路径读取配置", e);
        }
    }


    public static Properties getPropertiesFromResource(String classPath) {
        if (StringUtils.isBlank(classPath)) {
            logger.error("指定类资源路径为空");
            throw PropertiesException.instance("指定类资源路径为空");
        }

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();

        Resource resource = context.getResource(classPath);

        try (InputStream inputStream = resource.getInputStream()) {
            return getProperties(inputStream);
        } catch (IOException e) {
            logger.error("无法从指定类资源路径读取配置", e);
            throw PropertiesException.instance("无法从指定类资源路径读取配置", e);
        }
    }

    public static Properties getProperties(InputStream inputStream) {
        if (null == inputStream) {
            logger.error("指定文件输入流为空");
            throw PropertiesException.instance("指定文件输入流为空");
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))) {
            Properties properties = new Properties();
            properties.load(reader);
            logger.info("读取指定文件输入流配置成功", properties);
            return properties;
        } catch (IOException e) {
            logger.error("无法从指定文件输入流读取配置");
            throw PropertiesException.instance("无法从指定文件输入流读取配置", e);
        }
    }

    public static Properties getProperties(byte[] buf) {
        if (ArrayUtils.isEmpty(buf)) {
            logger.error("指定字节数组为空");
            throw PropertiesException.instance("指定字节数组为空");
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(buf), "UTF-8"))) {
            Properties properties = new Properties();
            properties.load(reader);
            logger.info("读取指定字节数组配置成功", properties);
            return properties;
        } catch (IOException e) {
            logger.error("无法从指定字节数组读取配置");
            throw PropertiesException.instance("无法从指定字节数组读取配置", e);
        }
    }
}
