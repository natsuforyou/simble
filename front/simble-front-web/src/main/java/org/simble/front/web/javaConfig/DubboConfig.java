package org.simble.front.web.javaConfig;

import com.alibaba.dubbo.config.spring.AnnotationBean;
import org.simble.framework.dubbo.support.javaConfig.DubboBaseConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DubboConfig extends DubboBaseConfig {

    @Bean
    public static AnnotationBean annotationBean() {
        AnnotationBean annotationBean = new AnnotationBean();
        annotationBean.setPackage("org.simble.front.web.controller");
        return annotationBean;
    }

}
