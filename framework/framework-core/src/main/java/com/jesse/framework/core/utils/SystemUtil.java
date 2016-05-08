/*
 * ©2016 Jesse. some rights reserved.
 */

package com.jesse.framework.core.utils;

/**
 * Created by Jesse Qian on 16-5-7.
 */
public class SystemUtil {
    public static boolean isWindows() {
        return System.getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1;
    }
}
