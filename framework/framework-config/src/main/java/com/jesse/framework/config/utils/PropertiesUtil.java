/*
 * ©2016 Jesse. some rights reserved.
 */

/*
 * ©2016 Jesse. some rights reserved.
 */

package com.jesse.framework.config.utils;

import com.jesse.framework.config.exception.PropertiesException;
import com.jesse.framework.spring.SpringApplicationContext;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.Properties;

/**
 * Created by Jesse Qian on 16-5-6.
 * load properties from filePath, classpath, inputStream and byte[]
 */
public class PropertiesUtil {

    private static final Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

    static Properties getProperties(final String filePath) {
        if (StringUtils.isBlank(filePath)) {
            logger.error("given file path is empty");
            throw PropertiesException.instance("given file path is empty");
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
            Properties properties = new Properties();
            properties.load(reader);
            logger.info("load properties from given file path successfully", properties);
            return properties;
        } catch (IOException e) {
            logger.error("fail to load properties from given file path");
            throw PropertiesException.instance("fail to load properties from given file path", e);
        }
    }


    private static Properties getProperties(final InputStream inputStream) {
        if (null == inputStream) {
            logger.error("given inputStream is empty");
            throw PropertiesException.instance("given inputStream is empty");
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))) {
            Properties properties = new Properties();
            properties.load(reader);
            logger.info("load properties from given inputStream successfully", properties);
            return properties;
        } catch (IOException e) {
            logger.error("fail to load properties from given inputStream");
            throw PropertiesException.instance("fail to load properties from given inputStream", e);
        }
    }

    static Properties getPropertiesFromResource(final String classpath) {
        if (StringUtils.isBlank(classpath)) {
            logger.error("given classpath is empty");
            throw PropertiesException.instance("given classpath is empty");
        }
        try (InputStream inputStream = new ClassPathResource(classpath).getInputStream()) {
            Properties properties = getProperties(inputStream);
            logger.info("load properties from given classpath successfully", properties);
            return properties;
        } catch (IOException e) {
            logger.error("fail to load properties from given classpath", e);
            throw PropertiesException.instance("fail to load properties from given classpath", e);
        }
    }

    public static Properties getProperties(final byte[] buf) {
        if (ArrayUtils.isEmpty(buf)) {
            logger.error("given byte array is empty");
            throw PropertiesException.instance("given byte array is empty");
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(buf), "UTF-8"))) {
            Properties properties = new Properties();
            properties.load(reader);
            logger.info("load properties from given byte array successfully", properties);
            return properties;
        } catch (IOException e) {
            logger.error("fail to load properties from given byte array");
            throw PropertiesException.instance("fail to load properties from given byte array", e);
        }
    }
}
