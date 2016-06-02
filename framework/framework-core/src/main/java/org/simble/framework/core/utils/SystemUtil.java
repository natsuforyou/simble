package org.simble.framework.core.utils;

public class SystemUtil {
    public static boolean isWindows() {
        return System.getProperty("os.name").toUpperCase().contains("WINDOWS");
    }
}
