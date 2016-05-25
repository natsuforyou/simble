/*
 * ©2016 Rick Qian. some rights reserved.
 */

/*
 * ©2016 Rick Qian. some rights reserved.
 */

package com.rick.qian.test.server.api.impl;

import com.rick.qian.test.api.HelloApi;
import com.rick.qian.test.service.HelloService;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.Resource;

/**
 * Created by Rick Qian on 16-5-13.
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
