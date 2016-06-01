/*
 * ©2016 Rick Qian. some rights reserved.
 */

package com.rick.qian.framework.config.enums;

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
