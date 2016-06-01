/*
 * ©2016 Rick Qian. some rights reserved.
 */

package com.rick.qian.front.controller.test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.rick.qian.front.common.response.wrappers.ObjectResult;
import com.rick.qian.test.api.HelloApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@ImportResource("classpath:spring/rick-front-*.xml")
@RestController
@EnableAutoConfiguration
@RequestMapping("/test")
public class TestController implements EmbeddedServletContainerCustomizer {

//    @Reference
    @Resource
    private HelloApi helloApi;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ObjectResult<String> hello() {
        String hello = helloApi.sayHello();
        return ObjectResult.success("操作成功", hello);
    }

    public static void main(String[] args) {
        SpringApplication.run(TestController.class, args);
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(8081);
    }
}
