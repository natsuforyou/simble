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
 * @see BasicConfRegistry
 * use javaConfig instead of xml config
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ContextJavaConfig.class)
//@ContextConfiguration(locations = "classpath:spring/framework-spring-context.xml")
public class TestBasicConfRegistry {

    @Test
    public void getConfPathTest() {
        System.out.println(BasicConfRegistry.getConfPrefix());
    }

    @Test
    public void getIpPathTest() {
        System.out.println(BasicConfRegistry.getIpPath());
    }

    @Test
    public void getAppNameTest() {
        System.out.println(BasicConfRegistry.getAppName());
    }

    @Test
    public void getIpTest() {
        System.out.println(BasicConfRegistry.getIp());
    }

    @Test
    public void isLocalTest() {
        System.out.println(BasicConfRegistry.isOnlyLocal());
    }

    @Test
    public void getZkConnectStringTest() {
        System.out.println(BasicConfRegistry.getZkConnectString());
    }

    @Test
    public void getZkConfPrefixTest() {
        System.out.println(BasicConfRegistry.getZkConfPrefix());
    }
}
