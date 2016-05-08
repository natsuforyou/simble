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

    private static Logger logger = LoggerFactory.getLogger(ConfigPathResolver.class);



//    private String getZkBasePath(){
//        return PropertiesReader.getValue(getZkServiceConfPath(), "zkBase");
//    }

    public static String getConfPath(String fileName, ConfScope scope, ConfLocation location){
        String separator = File.separator;
        return null;
    }
}
