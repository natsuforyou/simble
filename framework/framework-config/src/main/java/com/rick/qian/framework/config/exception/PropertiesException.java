/*
 * ©2016 Rick Qian. some rights reserved.
 */

package com.rick.qian.framework.config.exception;

public class PropertiesException extends RuntimeException {

    private static final long serialVersionUID = 5483151718629846906L;

    private PropertiesException(String message, Throwable cause) {
        super(message, cause);
    }

    public static PropertiesException instance(String message, Throwable cause) {
        return new PropertiesException(message, cause);
    }

    public static PropertiesException instance(String message) {
        return instance(message, null);
    }
}
