/*
 * ©2016 Rick Qian. some rights reserved.
 */

package com.rick.qian.front.javaConfig;

import com.alibaba.dubbo.config.spring.AnnotationBean;
import com.rick.qian.framework.dubbo.support.javaConfig.DubboBaseConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DubboConfig extends DubboBaseConfig {

    @Bean
    public static AnnotationBean annotationBean() {
        AnnotationBean annotationBean = new AnnotationBean();
        annotationBean.setPackage("com.rick.qian.front.controller");
        return annotationBean;
    }

}
