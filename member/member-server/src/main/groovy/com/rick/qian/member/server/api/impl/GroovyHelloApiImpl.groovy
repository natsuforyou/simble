/*
 * ©2016 Rick Qian. some rights reserved.
 */

package com.rick.qian.member.server.api.impl

import com.alibaba.dubbo.config.annotation.Service
import com.rick.qian.member.api.GroovyHelloApi
import com.rick.qian.member.service.GroovyHelloService

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
