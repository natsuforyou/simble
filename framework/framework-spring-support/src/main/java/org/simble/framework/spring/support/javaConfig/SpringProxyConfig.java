package org.simble.framework.spring.support.javaConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Rick Qian on 16-5-24.
 * spring context proxy JavaConfig file
 */
@Configuration
@ComponentScan(basePackages = "org.simble.framework.spring.support.context")
public class SpringProxyConfig {
}
