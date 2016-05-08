/*
 * ©2016 Jesse. some rights reserved.
 */

package com.jesse.framework.spring.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by Jesse Qian on 16-5-8.
 */
public class SpringApplicationContextProvider implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringApplicationContext.setContext(applicationContext);
    }

}
