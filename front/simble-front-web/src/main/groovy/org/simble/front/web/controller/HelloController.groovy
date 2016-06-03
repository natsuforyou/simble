package org.simble.front.web.controller

import com.alibaba.dubbo.config.annotation.Reference
import org.simble.common.response.wrappers.ObjectResult
import org.simble.member.api.HelloApi
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @Reference
    private HelloApi helloApi;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    def hello() {
        String hello = helloApi.sayHello()
        return ObjectResult.success(hello)
    }
}
