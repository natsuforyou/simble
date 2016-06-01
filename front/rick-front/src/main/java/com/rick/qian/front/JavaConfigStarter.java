/*
 * ©2016 Rick Qian. some rights reserved.
 */

package com.rick.qian.front;

import com.rick.qian.front.javaConfig.AopConfig;
import com.rick.qian.front.javaConfig.ContextConfig;
import com.rick.qian.front.javaConfig.DubboConfig;
import com.rick.qian.front.javaConfig.ImportConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@SpringBootApplication
@Import({ContextConfig.class, DubboConfig.class, AopConfig.class, ImportConfig.class})
public class JavaConfigStarter implements EmbeddedServletContainerCustomizer {

    private static Logger log = LoggerFactory.getLogger(JavaConfigStarter.class);

    @Resource
    private Environment env;

    public static void main(String[] args) {
        SpringApplication.run(JavaConfigStarter.class, args);
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(8081);
    }

//    @Override
//    protected SpringApplicationBuilder configure(
//            SpringApplicationBuilder application) {
//        log.info("=============容器启动（Spring Boot Container Start...）=============");
//        return application.sources(ContextConfig.class, DubboConfig.class, AopConfig.class, ImportConfig.class);
//    }
//
//    /**
//     * Config ServletListener, ServletFilter
//     */
//    @Override
//    public void onStartup(ServletContext servletContext)
//            throws ServletException {
//        log.info("+++++++++++++容器启动（Web Container Servetlet Start...）+++++++++++++");
//        log.info("++++++++++++++++++++++++++{}" + (env == null));
//
//        super.onStartup(servletContext);
//    }
}
