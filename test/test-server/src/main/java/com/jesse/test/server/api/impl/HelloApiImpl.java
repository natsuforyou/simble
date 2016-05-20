/*
 * ©2016 Jesse. some rights reserved.
 */

package com.jesse.test.server.api.impl;

import com.jesse.test.api.HelloApi;
import com.jesse.test.service.HelloService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Jesse Qian on 16-5-13.
 */
@ComponentScan
//@Service
@com.alibaba.dubbo.config.annotation.Service
public class HelloApiImpl implements HelloApi {

    @Resource
    private HelloService helloService;

    @Override
    public String sayHello() {
        return helloService.sayHello();
    }
}
