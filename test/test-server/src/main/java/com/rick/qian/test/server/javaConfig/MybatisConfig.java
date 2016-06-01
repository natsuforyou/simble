/*
 * ©2016 Rick Qian. some rights reserved.
 */

package com.rick.qian.test.server.javaConfig;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@MapperScan("com.rick.qian.test.dao.mapper")
public class MybatisConfig {

    @Resource
    private DataSource dataSource;

    @Resource
    private ResourcePatternResolver resolver;

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setConfigLocation(resolver.getResource("config/mybatis-configuration.xml"));
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("mybatis/mapper/**/*.xml"));
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

}
