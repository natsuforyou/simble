/*
 * ©2016 Rick Qian. some rights reserved.
 */

/*
 * ©2016 Rick Qian. some rights reserved.
 */

package com.rick.qian.member.service.impl

import com.rick.qian.member.service.GroovyHelloService
import org.springframework.stereotype.Service

@Service
class GroovyHelloServiceImpl implements GroovyHelloService {

    @Override
    def sayGroovyHello() {
        "hello groovy"
    }
}
