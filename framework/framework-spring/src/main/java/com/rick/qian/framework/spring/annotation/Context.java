/*
 * ©2016 Rick Qian. some rights reserved.
 */

package com.rick.qian.framework.spring.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Context {

    String value() default "";

}
