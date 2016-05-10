/*
 * ©2016 Jesse. some rights reserved.
 */

/*
 * ©2016 Jesse. some rights reserved.
 */

package com.jesse.framework.config.utils;

import com.jesse.framework.config.exception.PropertiesException;
import com.jesse.framework.spring.context.SpringApplicationContext;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;

import java.io.*;
import java.util.Properties;

/**
 * Created by Jesse Qian on 16-5-6.
 * load properties from filePath, classpath, inputStream and byte[]
 */
public class PropertiesUtil {

    private static final Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

    public static Properties getProperties(final String filePath) {
        if (StringUtils.isBlank(filePath)) {
            logger.error("指定文件系统路径为空");
            throw PropertiesException.instance("指定文件系统路径为空");
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
            Properties properties = new Properties();
            properties.load(reader);
            logger.info("读取指定文件系统路径配置成功", properties);
            return properties;
        } catch (IOException e) {
            logger.error("无法从指定文件系统路径读取配置");
            throw PropertiesException.instance("无法从指定文件系统路径读取配置", e);
        }
    }


    public static Properties getPropertiesFromResource(final String classpath) {
        if (StringUtils.isBlank(classpath)) {
            logger.error("指定类资源路径为空");
            throw PropertiesException.instance("指定类资源路径为空");
        }
        Resource resource = SpringApplicationContext.getContext().getResource(classpath);
        try (InputStream inputStream = resource.getInputStream()) {
            return getProperties(inputStream);
        } catch (IOException e) {
            logger.error("无法从指定类资源路径读取配置", e);
            throw PropertiesException.instance("无法从指定类资源路径读取配置", e);
        }
    }

    public static Properties getProperties(final InputStream inputStream) {
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

    public static Properties getProperties(final byte[] buf) {
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
