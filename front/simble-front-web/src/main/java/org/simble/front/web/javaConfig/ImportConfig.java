package org.simble.front.web.javaConfig;

import org.simble.framework.spring.support.javaConfig.SpringProxyConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(SpringProxyConfig.class)
public class ImportConfig {

}
