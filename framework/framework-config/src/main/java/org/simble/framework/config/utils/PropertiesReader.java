/*
 * ©2016 Rick Qian. some rights reserved.
 */

/*
 * ©2016 Rick Qian. some rights reserved.
 */

package org.simble.framework.config.utils;

/**
 * read properties by key
 */
class PropertiesReader {

    public static String getProperty(String filePath, String key) {
        return PropertiesUtil.getProperties(filePath).getProperty(key);
    }

    static String getPropertyFromResource(String classpath, String key) {
        return PropertiesUtil.getPropertiesFromResource(classpath).getProperty(key);
    }

    public static String getProperty(byte[] buf, String key) {
        return PropertiesUtil.getProperties(buf).getProperty(key);
    }


}
