/*
 * ©2016 Jesse. some rights reserved.
 */

package com.jesse.framework.config;

import com.jesse.framework.config.enums.ConfScope;
import com.jesse.framework.config.exception.PropertiesException;
import com.jesse.framework.config.utils.BasicConfRegistry;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.*;

/**
 * Created by Jesse Qian on 16-5-7.
 * customer PropertyPlaceholderConfigurer
 * {@link PropertyPlaceholderConfigurer}
 */
public class MyPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

    private static final Map<String, String> GLOBAL_PLACEHOLDERS = new HashMap<>();

    static {
        GLOBAL_PLACEHOLDERS.put("APP_NAME", BasicConfRegistry.getAppName());
        GLOBAL_PLACEHOLDERS.put("IP", BasicConfRegistry.getIp());
    }

    public void setPropertiesFiles(List<String> propertiesFiles) {
        if (CollectionUtils.isEmpty(propertiesFiles)) {
            throw PropertiesException.instance("must set properties files");
        }
        List<Properties> propertiesArray = new ArrayList<>();
        propertiesFiles.stream().forEach(propertiesFile -> {
            String[] filePath = propertiesFile.split(":");
            if (filePath.length == 2) {
                propertiesArray.add(FastConfigReader.getProperties(filePath[1], ConfScope.valueOf(filePath[0])));
            }
        });

        setPropertiesArray(propertiesArray.toArray(new Properties[]{}));

        setIgnoreUnresolvablePlaceholders(true);
    }

    @Override
    protected String resolvePlaceholder(String placeholder, Properties props) {
        String value = super.resolvePlaceholder(placeholder, props);
        if (null == value) {
            return GLOBAL_PLACEHOLDERS.get(placeholder);
        }
        return value;
    }
}
