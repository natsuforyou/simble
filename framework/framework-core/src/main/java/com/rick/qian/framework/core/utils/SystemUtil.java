/*
 * ©2016 Rick Qian. some rights reserved.
 */

package com.rick.qian.framework.core.utils;

public class SystemUtil {
    public static boolean isWindows() {
        return System.getProperty("os.name").toUpperCase().contains("WINDOWS");
    }
}
