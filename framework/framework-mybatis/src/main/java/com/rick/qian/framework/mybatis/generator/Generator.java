/*
 * ©2016 Rick Qian. some rights reserved.
 */

/*
 * ©2016 Rick Qian. some rights reserved.
 */

package com.rick.qian.framework.mybatis.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rick Qian on 16-5-7.
 */
public class Generator {

    public static void main(String[] args) {
        List<String> warnings = new ArrayList<>();
        try {
            boolean overwrite = true;
            File configFile = new File("/home/jiaxin/Dev/simple-soa-website/framework/framework-mybatis/src/main/resources/mybatis/mapping/test_mapping.xml");
            if (configFile.exists()) {
                ConfigurationParser cp = new ConfigurationParser(warnings);
                Configuration config = cp.parseConfiguration(configFile);
                for (Context context : config.getContexts()) {
                    context.addProperty("overwrite", String.valueOf(overwrite));
                }
                DefaultShellCallback callback = new DefaultShellCallback(overwrite);
                MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
                myBatisGenerator.generate(null);
                System.out.println("Success");
            } else
                System.out.println("沒有找到配置文件");// 配置文件中的项目地址和包引用地址要用绝对地址，否则不能生成
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
