/*
 * ©2016 Jesse. some rights reserved.
 */

package com.jesse.framework.config;

import com.jesse.framework.config.enums.ConfScope;
import com.jesse.framework.config.exception.PropertiesException;
import com.jesse.framework.config.utils.BasicConfRegistry;
import org.apache.commons.collections4.CollectionUtils;
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
            String[] strs = propertiesFile.split(":");
            if (strs.length == 2) {
                propertiesArray.add(FastConfigReader.getProperties(strs[1], ConfScope.valueOf(strs[0])));
            }
        });

        setPropertiesArray((Properties[]) propertiesArray.toArray());

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
