package org.simble.framework.config.utils;

import org.simble.framework.spring.support.javaConfig.SpringProxyConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @see PathResolver
 * use javaConfig instead of xml config
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringProxyConfig.class)
//@ContextConfiguration(locations = "classpath:spring/framework-spring-proxy.xml")
public class TestPathResolver {

    @Test
    public void getIpPathTest() {
        System.out.println(PathResolver.getSolvedIpPath());
    }
}
