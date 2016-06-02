/*
 * ©2016 Rick Qian. some rights reserved.
 */

package com.rick.qian.front.controller

import com.alibaba.dubbo.config.annotation.Reference
import com.rick.qian.front.common.response.wrappers.ObjectResult
import com.rick.qian.test.api.GroovyHelloApi
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class GroovyTestController {

    @Reference
    private GroovyHelloApi groovyHelloApi;

    @RequestMapping(value = "/sayGroovyHello", method = RequestMethod.GET)
    def hello() {
        String hello = groovyHelloApi.sayGroovyHello()
        ObjectResult.success("操作成功", hello)
    }
}
