/*
 * ©2016 Jesse. some rights reserved.
 */

package com.jesse.framework.config.enums;

/**
 * Created by Jesse Qian on 16-5-6.
 */
public enum ConfScope {
    G("全局配置"),
    P("项目配置");

    private String desc;

    ConfScope(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
