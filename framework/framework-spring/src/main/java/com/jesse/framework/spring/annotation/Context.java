/*
 * ©2016 Jesse. some rights reserved.
 */

package com.jesse.framework.spring.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by Jesse Qian on 16-5-9.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Context {

    String value() default "";

}
