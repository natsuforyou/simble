/*
 * ©2016 Jesse. some rights reserved.
 */

package com.jesse.framework.spring;

import org.springframework.context.ApplicationContext;

/**
 * Created by Jesse Qian on 16-5-8.
 */
public class SpringApplicationContext {

    private static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext applicationContext) {
        SpringApplicationContext.applicationContext = applicationContext;
    }

    public static <T> T getBean(Class<T> requiredType) {
        return applicationContext.getBean(requiredType);
    }
}
