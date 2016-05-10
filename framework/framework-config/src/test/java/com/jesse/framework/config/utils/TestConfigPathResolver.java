/*
 * ©2016 Jesse. some rights reserved.
 */

package com.jesse.framework.config.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Jesse Qian on 16-5-9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/spring/framework-config-test.xml")
public class TestConfigPathResolver {

    @Test
    public void getIpPathTest() {
        System.out.println(PropertiesPathResolver.getIpPath());
    }
}
