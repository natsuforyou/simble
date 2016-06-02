/*
 * ©2016 Rick Qian. some rights reserved.
 */

package org.simble.member.server.javaConfig;

import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import org.simble.framework.dubbo.support.javaConfig.DubboBaseConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DubboConfig extends DubboBaseConfig{

    @Bean
    public ProtocolConfig protocolConfig(){
        ProtocolConfig protocolConfig=new ProtocolConfig("dubbo",20881);
        protocolConfig.setHost(placeholderConfigurer.getProperty("ip"));
        protocolConfig.setSerialization("kryo");
        return protocolConfig;
    }

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
    public static AnnotationBean annotationBean() {
        AnnotationBean annotationBean = new AnnotationBean();
        annotationBean.setPackage("org.simble.member.server.api.impl");
        return annotationBean;
    }

}
