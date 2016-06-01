/*
 * ©2016 Rick Qian. some rights reserved.
 */

package com.rick.qian.front.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.rick.qian.front.common.response.wrappers.ObjectResult;
import com.rick.qian.test.api.HelloApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Reference
    private HelloApi helloApi;

    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    public ObjectResult<String> hello() {
        String hello = helloApi.sayHello();
        return ObjectResult.success("操作成功", hello);
    }
}
