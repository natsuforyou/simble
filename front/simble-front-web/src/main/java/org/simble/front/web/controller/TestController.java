package org.simble.front.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.simble.common.response.wrappers.ObjectResult;
import org.simble.member.api.HelloApi;
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
