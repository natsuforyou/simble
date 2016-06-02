package org.simble.member.server.api.impl

import com.alibaba.dubbo.config.annotation.Service
import org.simble.member.api.GroovyHelloApi
import org.simble.member.service.GroovyHelloService

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
