/*
 * ©2016 Rick Qian. some rights reserved.
 */

package com.rick.qian.test.server.javaConfig;

import com.rick.qian.framework.spring.javaConfig.SpringProxyConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Rick Qian on 16-5-31.
 */
@Configuration
@Import(SpringProxyConfig.class)
public class ImportConfig {

}
