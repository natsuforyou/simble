/*
 * ©2016 Jesse. some rights reserved.
 */

package com.jesse.framework.config;

import com.jesse.framework.config.exception.PropertiesException;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.List;

/**
 * Created by Jesse Qian on 16-5-7.
 */
public class MyPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

    public void setProperties(List<String> properties) {
        if (CollectionUtils.isEmpty(properties)) {
            throw PropertiesException.instance("必须设置文件路径列表");
        }

    }
}
