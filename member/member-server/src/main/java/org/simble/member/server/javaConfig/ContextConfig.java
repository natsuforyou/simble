package org.simble.member.server.javaConfig;

import org.simble.framework.config.CustomPropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan("org.simble.member.service")
public class ContextConfig {

    @Bean
    public static CustomPropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
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
