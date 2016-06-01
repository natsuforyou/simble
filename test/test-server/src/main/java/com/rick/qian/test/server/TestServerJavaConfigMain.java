/*
 * ©2016 Rick Qian. some rights reserved.
 */

package com.rick.qian.test.server;

import com.alibaba.dubbo.container.Main;

/**
 * Created by Rick Qian on 16-5-31.
 * dubbo server started with javaConfig
 */
public class TestServerJavaConfigMain {
    public static void main(String[] args) {
        String[] configs = {"javaconfig"};
        Main.main(configs);
    }
}
