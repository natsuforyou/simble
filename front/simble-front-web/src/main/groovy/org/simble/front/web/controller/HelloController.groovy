package org.simble.front.web.controller

import com.alibaba.dubbo.config.annotation.Reference
import org.simble.common.response.wrappers.ObjectResult
import org.simble.member.api.HelloApi
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    private static Logger logger = LoggerFactory.getLogger(HelloController.class)

    @Reference
    private HelloApi helloApi;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    def hello() {
        String hello = helloApi.sayHello()
        ObjectResult.success(hello)
    }

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    def testException() {
        helloApi.testException()
    }

    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    def testCustomeException() {
        helloApi.testCustomException()
    }
}
