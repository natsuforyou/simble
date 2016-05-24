/*
 * ©2016 Jesse. some rights reserved.
 */

package com.jesse.framework.config.utils;

import com.jesse.framework.spring.javaConfig.ContextJavaConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Jesse Qian on 16-5-9.
 * @see PathResolver
 * use javaConfig instead of xml config
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ContextJavaConfig.class)
//@ContextConfiguration(locations = "classpath:spring/framework-spring-context.xml")
public class TestPathResolver {

    @Test
    public void getIpPathTest() {
        System.out.println(PathResolver.getSolvedIpPath());
    }
}
