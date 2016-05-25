/*
 * ©2016 Rick Qian. some rights reserved.
 */

/*
 * ©2016 Rick Qian. some rights reserved.
 */

package com.rick.qian.framework.spring.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by Rick Qian on 16-5-9.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Context {

    String value() default "";

}
