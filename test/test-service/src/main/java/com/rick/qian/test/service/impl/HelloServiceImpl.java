/*
 * ©2016 Rick Qian. some rights reserved.
 */

package com.rick.qian.test.service.impl;

import com.rick.qian.test.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello() {
        return "hello";
    }
}
