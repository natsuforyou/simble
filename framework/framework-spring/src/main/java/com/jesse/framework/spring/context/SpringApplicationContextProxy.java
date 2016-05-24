/*
 * ©2016 Jesse. some rights reserved.
 */

package com.jesse.framework.spring.context;

import com.jesse.framework.spring.SpringApplicationContext;
import com.jesse.framework.spring.annotation.Context;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Jesse Qian on 16-5-8.
 */
@Context
public class SpringApplicationContextProxy implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringApplicationContext.setApplicationContext(applicationContext);
    }

}
