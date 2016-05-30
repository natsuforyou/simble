/*
 * ©2016 Rick Qian. some rights reserved.
 */

package com.rick.qian.front.controller.test;

import com.rick.qian.front.common.response.wrappers.ObjectResult;
import com.rick.qian.test.api.HelloApi;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Rick Qian on 16-5-30.
 */

@RequestMapping("/test")
@Controller
public class TestController {

    @Reference
    @Resource
    private HelloApi helloApi;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public ObjectResult<String> hello() {
        String hello = helloApi.sayHello();
        return ObjectResult.success("操作成功", hello);
    }

    public static void main(String[] args) {

    }

}
