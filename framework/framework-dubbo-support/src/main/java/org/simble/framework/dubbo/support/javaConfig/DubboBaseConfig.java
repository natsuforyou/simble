package org.simble.framework.dubbo.support.javaConfig;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import org.simble.framework.config.CustomPropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

public class DubboBaseConfig {

    @Resource
    protected CustomPropertyPlaceholderConfigurer placeholderConfigurer;

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
        registryConfig.setFile("/data/appData/dubbo/cache/" + placeholderConfigurer.getProperty("app.name") + ".cache");
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
}
