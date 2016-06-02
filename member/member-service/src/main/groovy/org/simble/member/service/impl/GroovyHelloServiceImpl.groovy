package org.simble.member.service.impl

import org.simble.member.service.GroovyHelloService
import org.springframework.stereotype.Service

@Service
class GroovyHelloServiceImpl implements GroovyHelloService {

    @Override
    def sayGroovyHello() {
        "hello groovy"
    }
}
