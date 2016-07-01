package org.simble.member.server;

import com.alibaba.dubbo.container.Main;

/**
 * dubbo server started with javaConfig
 */
public class MemberServerMain {
    public static void main(String[] args) {
        String[] configs = {"javaconfig"};
        Main.main(configs);
    }
}
