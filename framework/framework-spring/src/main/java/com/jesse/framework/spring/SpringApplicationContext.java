/*
 * ©2016 Jesse. some rights reserved.
 */

package com.jesse.framework.spring;

import org.springframework.context.ApplicationContext;

/**
 * Created by Jesse Qian on 16-5-8.
 */
public class SpringApplicationContext {

    private static ApplicationContext context;

    public static ApplicationContext getContext() {
        return context;
    }

    public static void setContext(ApplicationContext applicationContext) {
        context = applicationContext;
    }
}
