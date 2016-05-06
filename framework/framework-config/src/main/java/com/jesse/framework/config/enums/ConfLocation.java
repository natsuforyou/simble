/*
 * ©2016 Jesse. some rights reserved.
 */

package com.jesse.framework.config.enums;

/**
 * Created by Jesse Qian on 16-5-6.
 */
public enum ConfLocation {
    ZK("zookeeper"),
    CACHE("缓存"),
    FS("文件系统");

    private String desc;

    ConfLocation(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
