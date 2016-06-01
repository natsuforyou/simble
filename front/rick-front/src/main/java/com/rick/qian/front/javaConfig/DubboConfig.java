/*
 * ©2016 Rick Qian. some rights reserved.
 */

package com.rick.qian.front.javaConfig;

import com.alibaba.dubbo.config.*;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import com.rick.qian.framework.config.CustomPropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class DubboConfig {

    @Resource
    private CustomPropertyPlaceholderConfigurer placeholderConfigurer;

    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(placeholderConfigurer.getProperty("app.name"));
        applicationConfig.setOwner("Rick.Qian");
        applicationConfig.setLogger("slf4j");
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress(placeholderConfigurer.getProperty("connectionString"));
        registryConfig.setFile("/data/programData/dubbo/cache/" + placeholderConfigurer.getProperty("app.name") + ".cache");
        return registryConfig;
    }

    @Bean
    public ConsumerConfig consumerConfig() {
        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setTimeout(60000);
        consumerConfig.setRetries(0);
        consumerConfig.setCheck(false);
        return consumerConfig;
    }

//    @Bean
//    public static AnnotationBean annotationBean() {
//        AnnotationBean annotationBean = new AnnotationBean();
//        annotationBean.setPackage("com.rick.qian.front.controller");
//        return annotationBean;
//    }

}
