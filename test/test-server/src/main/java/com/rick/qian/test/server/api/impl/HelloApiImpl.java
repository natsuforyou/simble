/*
 * ©2016 Rick Qian. some rights reserved.
 */

package com.rick.qian.test.server.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.rick.qian.test.api.HelloApi;
import com.rick.qian.test.service.HelloService;

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
