package org.simble.member.server.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.simble.member.api.HelloApi;
import org.simble.member.service.HelloService;

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
