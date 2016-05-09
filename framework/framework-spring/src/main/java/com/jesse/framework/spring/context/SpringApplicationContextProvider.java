/*
 * ©2016 Jesse. some rights reserved.
 */

package com.jesse.framework.spring.context;

import com.jesse.framework.spring.annotation.Context;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by Jesse Qian on 16-5-8.
 */
@Context
public class SpringApplicationContextProvider implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringApplicationContext.setContext(applicationContext);
    }

}
