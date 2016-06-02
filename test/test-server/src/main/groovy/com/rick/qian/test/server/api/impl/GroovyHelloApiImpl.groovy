/*
 * ©2016 Rick Qian. some rights reserved.
 */

package com.rick.qian.test.server.api.impl

import com.alibaba.dubbo.config.annotation.Service
import com.rick.qian.test.api.GroovyHelloApi
import com.rick.qian.test.service.GroovyHelloService

import javax.annotation.Resource

@Service
class GroovyHelloApiImpl implements GroovyHelloApi {

    @Resource
    private GroovyHelloService groovyHelloService

    @Override
    def sayGroovyHello() {
        groovyHelloService.sayGroovyHello()
    }
}
