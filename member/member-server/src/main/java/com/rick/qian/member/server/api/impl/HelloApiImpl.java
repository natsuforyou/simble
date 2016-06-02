/*
 * ©2016 Rick Qian. some rights reserved.
 */

package com.rick.qian.member.server.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.rick.qian.member.api.HelloApi;
import com.rick.qian.member.service.HelloService;

import javax.annotation.Resource;

@Service
public class HelloApiImpl implements HelloApi {

    @Resource
    private HelloService helloService;

    @Override
    public String sayHello() {
        return helloService.sayHello();
    }
}
