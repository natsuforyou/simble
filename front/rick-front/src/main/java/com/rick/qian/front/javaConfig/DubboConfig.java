/*
 * ©2016 Rick Qian. some rights reserved.
 */

package com.rick.qian.front.javaConfig;

import com.rick.qian.framework.dubbo.support.javaConfig.DubboBaseConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DubboBaseConfig.class)
public class DubboConfig {

//    @Bean
//    public static AnnotationBean annotationBean() {
//        AnnotationBean annotationBean = new AnnotationBean();
//        annotationBean.setPackage("com.rick.qian.front.controller");
//        return annotationBean;
//    }

}
