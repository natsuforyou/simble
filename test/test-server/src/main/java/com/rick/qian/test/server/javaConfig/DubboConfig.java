/*
 * ©2016 Rick Qian. some rights reserved.
 */

package com.rick.qian.test.server.javaConfig;

import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import com.rick.qian.framework.dubbo.support.javaConfig.DubboBaseConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DubboConfig extends DubboBaseConfig{

    @Bean
    public ProviderConfig providerConfig() {
        ProviderConfig providerConfig = new ProviderConfig();
        providerConfig.setThreads(150);
        providerConfig.setExecutes(100);
        providerConfig.setAccesslog(true);
        providerConfig.setFilter("-exception");
        return providerConfig;
    }

    @Bean
    public ProtocolConfig protocolConfig(){
        ProtocolConfig protocolConfig=new ProtocolConfig("dubbo",20001);
        protocolConfig.setHost(placeholderConfigurer.getProperty("ip"));
        protocolConfig.setSerialization("java");
        return protocolConfig;
    }

    @Bean
    public static AnnotationBean annotationBean() {
        AnnotationBean annotationBean = new AnnotationBean();
        annotationBean.setPackage("com.rick.qian.test.server.api.impl");
        return annotationBean;
    }

}
