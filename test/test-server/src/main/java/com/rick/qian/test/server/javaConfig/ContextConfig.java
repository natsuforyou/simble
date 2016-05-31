/*
 * ©2016 Rick Qian. some rights reserved.
 */

package com.rick.qian.test.server.javaConfig;

import com.rick.qian.framework.config.MyPropertyPlaceholderConfigurer;
import org.mybatis.spring.annotation.MapperScan;
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
@MapperScan("com.rick.qian.test.dao.mapper")
public class ContextConfig {

    @Bean
    public static MyPropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        MyPropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new MyPropertyPlaceholderConfigurer();
        List<String> propertiesFiles = new ArrayList();
        propertiesFiles.add("G:properties/zkService.properties");
        propertiesFiles.add("G:properties/mysql-jdbc.properties");
        propertiesFiles.add("P:properties/mysql-jdbc.properties");
        propertyPlaceholderConfigurer.setPropertiesFiles(propertiesFiles);
        return propertyPlaceholderConfigurer;
    }

    @Bean
    public ResourcePatternResolver resolver() {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        return resolver;
    }
}
