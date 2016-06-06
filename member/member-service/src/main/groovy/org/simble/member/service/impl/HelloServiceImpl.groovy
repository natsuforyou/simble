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

    /**
     * 走dubbo的ExceptionFilter，堆栈被吃
     * 如果e.printStackTrace()，则堆栈又会出现
     * 自定义异常正常
     *
     * 如果dubbo配置filter="-exception"，
     * 异常堆栈都会被吃，但是如果把自定义异常的空参构造器去掉，则自定义异常可以出现
     */
    @Override
    void testException() throws Exception {
        try {
            throw new ArrayIndexOutOfBoundsException("异常");
        } catch (ArrayIndexOutOfBoundsException e) {
//            e.printStackTrace()
            throw e
        }
    }

    @Override
    void testCustomException() throws Exception {
        throw PropertiesException.instance("自定义异常")

    }
}
