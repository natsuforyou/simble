/*
 * ©2016 Rick Qian. some rights reserved.
 */

package com.rick.qian.framework.spring.context;

import com.rick.qian.framework.spring.SpringApplicationContext;
import com.rick.qian.framework.spring.annotation.Context;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@Context
public class SpringApplicationContextProxy implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringApplicationContext.setApplicationContext(applicationContext);
    }

}
