/*
 * ©2016 Rick Qian. some rights reserved.
 */

package org.simble.member.server.javaConfig;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.simble.framework.config.CustomPropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.beans.PropertyVetoException;

@Configuration
public class DataSourceConfig {

    @Resource
    private CustomPropertyPlaceholderConfigurer placeholderConfigurer;

    @Bean(destroyMethod = "close")
    public ComboPooledDataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDataSourceName("member-dataSource");
        dataSource.setDriverClass(placeholderConfigurer.getProperty("jdbc.driver"));
        dataSource.setJdbcUrl(placeholderConfigurer.getProperty("jdbc.url"));
        dataSource.setUser(placeholderConfigurer.getProperty("jdbc.username"));
        dataSource.setPassword(placeholderConfigurer.getProperty("jdbc.password"));
        dataSource.setInitialPoolSize(Integer.parseInt(placeholderConfigurer.getProperty("jdbc.initialPoolSize")));
        dataSource.setMinPoolSize(Integer.parseInt(placeholderConfigurer.getProperty("jdbc.minPoolSize")));
        dataSource.setMaxPoolSize(Integer.parseInt(placeholderConfigurer.getProperty("jdbc.maxPoolSize")));
        dataSource.setPreferredTestQuery("SELECT NOW()");
        dataSource.setCheckoutTimeout(30000);
        dataSource.setTestConnectionOnCheckin(true);
        dataSource.setTestConnectionOnCheckout(true);
        dataSource.setMaxIdleTime(10);
        return dataSource;
    }

}
