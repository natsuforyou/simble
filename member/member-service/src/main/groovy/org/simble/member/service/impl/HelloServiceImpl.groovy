package org.simble.member.service.impl

import org.simble.framework.config.exception.PropertiesException
import org.simble.member.service.HelloService
import org.springframework.stereotype.Service

@Service
class HelloServiceImpl implements HelloService {

    @Override
    String sayHello() {
        "hello"
    }
    
    @Override
    void testException() throws Exception {
        throw new ArrayIndexOutOfBoundsException("异常");
    }

    @Override
    void testCustomException() throws Exception {
        throw PropertiesException.instance("自定义异常")
    }
}
