package org.simble.framework.config;

import org.simble.framework.config.enums.ConfScope;
import org.simble.framework.config.exception.PropertiesException;
import org.simble.framework.config.utils.BasicConfRegistry;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.*;

/**
 * customer PropertyPlaceholderConfigurer
 * {@link PropertyPlaceholderConfigurer}
 */
public class CustomPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

    private static final Map<String, String> GLOBAL_PLACEHOLDERS = new HashMap<>();

    private Properties placeHolders;

    static {
        GLOBAL_PLACEHOLDERS.put("app.name", BasicConfRegistry.getAppName());
        GLOBAL_PLACEHOLDERS.put("ip", BasicConfRegistry.getIp());
    }

    public void setPropertiesFiles(List<String> propertiesFiles) {
        if (CollectionUtils.isEmpty(propertiesFiles)) {
            throw PropertiesException.instance("must set properties files");
        }
        List<Properties> propertiesArray = new ArrayList<>();
        propertiesFiles.stream().forEach(propertiesFile -> {
            String[] filePath = propertiesFile.split(":");
            if (filePath.length == 2) {
                propertiesArray.add(FastConfigReader.getProperties(filePath[1], ConfScope.valueOf(filePath[0])));
            }
        });

        setPropertiesArray(propertiesArray.toArray(new Properties[]{}));

        setIgnoreUnresolvablePlaceholders(true);
    }

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        placeHolders = props;
    }

    @Override
    protected String resolvePlaceholder(String placeholder, Properties props) {
        String value = super.resolvePlaceholder(placeholder, props);
        if (null == value) {
            return GLOBAL_PLACEHOLDERS.get(placeholder);
        }
        return value;
    }

    public String getProperty(String key) {
        return resolvePlaceholder(key, placeHolders);
    }
}
