package org.simble.member.service.impl

import org.simble.member.service.HelloService
import org.springframework.stereotype.Service

@Service
class HelloServiceImpl implements HelloService {

    @Override
    String sayHello() {
        "hello"
    }
}
