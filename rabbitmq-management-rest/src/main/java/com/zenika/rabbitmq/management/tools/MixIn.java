package com.zenika.rabbitmq.management.tools;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to auto-detect mixins
 *
 * @author Colin Hebert
 */
@Retention(RetentionPolicy.RUNTIME)
@Target( { ElementType.TYPE })
public @interface MixIn {
	Class<?> value() default Void.class;
}
