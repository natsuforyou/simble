/*
 * ©2016 Rick Qian. some rights reserved.
 */

package com.rick.qian.framework.mybatis.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

public class Generator {

    public static void main(String[] args) throws Exception {

        Resource resource = new PathMatchingResourcePatternResolver().getResource("mybatis/mapping/member_mapping.xml");

        if (resource.exists()) {

            Configuration config = new ConfigurationParser(null).parseConfiguration(resource.getInputStream());

            config.getContexts().stream()
                    .forEach(context -> context.addProperty("overwrite", Boolean.TRUE.toString()));

            new MyBatisGenerator(config, new DefaultShellCallback(true), null).generate(null);

            System.out.println("Success");
        } else {
            System.out.println("沒有找到配置文件");
        }
    }
}
