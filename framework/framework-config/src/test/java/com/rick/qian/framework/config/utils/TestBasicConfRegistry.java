/*
 * ©2016 Rick Qian. some rights reserved.
 */

package com.rick.qian.framework.config.utils;

import com.rick.qian.framework.spring.javaConfig.SpringProxyConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @see BasicConfRegistry
 * use javaConfig instead of xml config
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringProxyConfig.class)
//@ContextConfiguration(locations = "classpath:spring/framework-spring-proxy.xml")
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
