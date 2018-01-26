/**
 * @author kexiaohong
 * @version 1.0 2018年1月26日
 *
 */
package com.item.base.entity.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(FIELD)
@Retention(RUNTIME)
public @interface Example {
	String value() default "";
}
