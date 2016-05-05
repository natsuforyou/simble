/*
 * ©2016 Jesse. some rights reserved.
 */

package com.jesse.framework.core.utils;

import com.jesse.framework.core.exception.PropertiesException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

/**
 * Created by Jesse Qian on 16-5-6.
 */
public class PropertiesUtil {

    private Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

    public Properties getProperties(String path) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"))) {
            Properties properties = new Properties();
            properties.load(reader);
            return properties;
        } catch (IOException e) {
            logger.error("");
            throw PropertiesException.instance("", e);
        }
    }

    public Properties getProperties(InputStream inputStream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))) {
            Properties properties = new Properties();
            properties.load(reader);
            return properties;
        } catch (IOException e) {
            logger.error("");
            throw PropertiesException.instance("", e);
        }
    }

    public Properties getProperties(byte[] buf) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(buf), "UTF-8"))) {
            Properties properties = new Properties();
            properties.load(reader);
            return properties;
        } catch (IOException e) {
            logger.error("");
            throw PropertiesException.instance("", e);
        }
    }
}
