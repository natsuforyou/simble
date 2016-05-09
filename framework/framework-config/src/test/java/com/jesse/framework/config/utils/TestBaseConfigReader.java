/*
 * ©2016 Jesse. some rights reserved.
 */

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
public class TestBaseConfigReader {

    @Test
    public void getConfPathTest() {
        System.out.println(BaseConfigReader.getConfPath());
    }

    @Test
    public void getIpPathTest() {
        System.out.println(BaseConfigReader.getIpPath());
    }

    @Test
    public void getIpTest() {
        System.out.println(BaseConfigReader.getIp());
    }
}
