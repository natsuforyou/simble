/*
 * ©2016 Jesse. some rights reserved.
 */

package com.jesse.framework.core.exception;

/**
 * Created by Jesse Qian on 16-5-6.
 */
public class PropertiesException extends RuntimeException {

    private static final long serialVersionUID = 5483151718629846906L;

    private PropertiesException(String message, Throwable cause) {
        super(message, cause);
    }

    public static PropertiesException instance(String message, Throwable cause) {
        return new PropertiesException(message, cause);
    }
}
