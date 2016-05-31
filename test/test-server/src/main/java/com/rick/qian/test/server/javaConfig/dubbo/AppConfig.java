/*
 * ©2016 Rick Qian. some rights reserved.
 */

/*
 * ©2016 Rick Qian. some rights reserved.
 */

package com.rick.qian.test.server.javaConfig.dubbo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import com.rick.qian.test.server.javaConfig.MybatisConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Rick Qian on 16-5-31.
 */
@Configuration
@Import({MybatisConfig.class})
public class AppConfig {

    private String appName;

    private String ip;

    private String connectionString;

    private String userHome;

    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setLogger("slf4j");
        applicationConfig.setName(appName);
        applicationConfig.setOwner("Rick.Qian");
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress(connectionString);
        registryConfig.setFile(userHome + "/dubbo/cache/" + userHome + ".cache");
        return registryConfig;
    }

    @Bean
    public ProviderConfig providerConfig() {
        ProviderConfig providerConfig = new ProviderConfig();
        providerConfig.setThreads(150);
        providerConfig.setExecutes(100);
//        providerConfig.setHost(ip);
        return providerConfig;
    }

    @Bean
    public AnnotationBean annotationBean() {
        AnnotationBean annotationBean = new AnnotationBean();
        annotationBean.setPackage("com.rick.qian.test.server.api.impl");
        return annotationBean;
    }

    @Bean
    public ProtocolConfig protocolConfig(){
        ProtocolConfig protocolConfig=new ProtocolConfig("dubbo",20880);
        protocolConfig.setHost(ip);
        protocolConfig.setSerialization("java");//默认为hessian2,但不支持无参构造函数类,而这种方式的效率很低
        return protocolConfig;
    }

    @Value("#{APP_NAME}")
    public void setAppName(String appName) {
        this.appName = appName;
    }

    @Value("#{IP}")
    public void setIp(String ip) {
        this.ip = ip;
    }

    @Value("#{connectionString}")
    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    @Value("#{user.home}")
    public void setUserHome(String userHome) {
        this.userHome = userHome;
    }
}
