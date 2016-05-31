/*
 * ©2016 Rick Qian. some rights reserved.
 */

package com.rick.qian.test.server.javaConfig;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

/**
 * Created by Rick Qian on 16-5-31.
 */
@Configuration
public class DataSourceConfig {

    private String driverClass;

    private String jdbcUrl ;

    private String user ;

    private String password ;

    private int initialPoolSize ;

    private int minPoolSize ;

    private int maxPoolSize ;

    @Bean(destroyMethod = "close")
    public ComboPooledDataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDataSourceName("test-dataSource");
        dataSource.setDriverClass(driverClass);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setInitialPoolSize(initialPoolSize);
        dataSource.setMinPoolSize(minPoolSize);
        dataSource.setMaxPoolSize(maxPoolSize);
        dataSource.setPreferredTestQuery("SELECT NOW()");
        dataSource.setCheckoutTimeout(30000);
        dataSource.setTestConnectionOnCheckin(true);
        dataSource.setTestConnectionOnCheckout(true);
        dataSource.setMaxIdleTime(10);
        return dataSource;
    }

    @Value("#{jdbc.driver}")
    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    @Value("#{jdbc.url}")
    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    @Value("#{jdbc.username}")
    public void setUser(String user) {
        this.user = user;
    }

    @Value("#{jdbc.password}")
    public void setPassword(String password) {
        this.password = password;
    }

    @Value("#{jdbc.initialPoolSize}")
    public void setInitialPoolSize(int initialPoolSize) {
        this.initialPoolSize = initialPoolSize;
    }

    @Value("#{jdbc.minPoolSize}")
    public void setMinPoolSize(int minPoolSize) {
        this.minPoolSize = minPoolSize;
    }

    @Value("#{jdbc.maxPoolSize}")
    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }
}
