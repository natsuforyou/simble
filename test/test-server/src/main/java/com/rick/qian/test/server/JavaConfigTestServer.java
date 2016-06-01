/*
 * ©2016 Rick Qian. some rights reserved.
 */

package com.rick.qian.test.server;

import com.alibaba.dubbo.container.Main;

/**
 * dubbo server started with javaConfig
 */
public class JavaConfigTestServer {
    public static void main(String[] args) {
        String[] configs = {"javaconfig"};
        Main.main(configs);
    }
}
