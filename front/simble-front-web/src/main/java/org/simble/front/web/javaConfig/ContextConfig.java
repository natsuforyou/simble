package org.simble.front.web.javaConfig;

import org.simble.framework.config.CustomPropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ContextConfig {

    @Bean
    public CustomPropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        CustomPropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new CustomPropertyPlaceholderConfigurer();
        List<String> propertiesFiles = new ArrayList<>();
        propertiesFiles.add("G:properties/zkService.properties");
        propertyPlaceholderConfigurer.setPropertiesFiles(propertiesFiles);
        return propertyPlaceholderConfigurer;
    }

    @Bean
    public ResourcePatternResolver resolver() {
        return new PathMatchingResourcePatternResolver();
    }

}
