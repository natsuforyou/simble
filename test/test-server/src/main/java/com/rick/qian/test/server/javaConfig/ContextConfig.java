/*
 * ©2016 Rick Qian. some rights reserved.
 */

package com.rick.qian.test.server.javaConfig;

import com.rick.qian.framework.config.CustomPropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rick Qian on 16-5-31.
 */
@Configuration
@ComponentScan("com.rick.qian.test.service")
public class ContextConfig {

    @Bean
    public CustomPropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        CustomPropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new CustomPropertyPlaceholderConfigurer();
        List<String> propertiesFiles = new ArrayList<>();
        propertiesFiles.add("G:properties/zkService.properties");
        propertiesFiles.add("G:properties/mysql-jdbc.properties");
        propertiesFiles.add("P:properties/mysql-jdbc.properties");
        propertyPlaceholderConfigurer.setPropertiesFiles(propertiesFiles);
        return propertyPlaceholderConfigurer;
    }

    @Bean
    public ResourcePatternResolver resolver() {
        return new PathMatchingResourcePatternResolver();
    }

}
