/*
 * ©2016 Jesse. some rights reserved.
 */

package com.jesse.test.service.impl;

import com.jesse.test.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * Created by Jesse Qian on 16-5-13.
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello() {
        return "hello";
    }
}
