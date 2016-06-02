/*
 * ©2016 Rick Qian. some rights reserved.
 */

package com.rick.qian.test.service.impl

import com.rick.qian.test.service.GroovyHelloService
import org.springframework.stereotype.Service

@Service
class GroovyHelloServiceImpl implements GroovyHelloService {

    @Override
    def sayGroovyHello() {
        "hello groovy"
    }
}
