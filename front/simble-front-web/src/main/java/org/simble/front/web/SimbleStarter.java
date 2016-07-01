package org.simble.front.web;

import org.simble.front.web.javaConfig.AopConfig;
import org.simble.front.web.javaConfig.ContextConfig;
import org.simble.front.web.javaConfig.DubboConfig;
import org.simble.front.web.javaConfig.ImportConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration
@Import({ContextConfig.class, DubboConfig.class, AopConfig.class, ImportConfig.class})
public class SimbleStarter implements EmbeddedServletContainerCustomizer {

    public static void main(String[] args) {
        SpringApplication.run(SimbleStarter.class, args);
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(8081);
    }

}
