/*
 * ©2016 Rick Qian. some rights reserved.
 */

package com.rick.qian.front.javaConfig;

import com.rick.qian.framework.spring.javaConfig.SpringProxyConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(SpringProxyConfig.class)
public class ImportConfig {

}
