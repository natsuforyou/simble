package org.simble.framework.spring.support.context;

import org.simble.framework.spring.support.SpringApplicationContext;
import org.simble.framework.spring.support.annotation.Context;
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
