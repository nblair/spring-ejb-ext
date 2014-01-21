/**
 * 
 */
package com.github.nblair.spring.ejb;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Proxy;

import javax.ejb.Local;

import org.springframework.context.annotation.Import;

/**
 * When present on a {@link Configuration} class, this enables automatic binding of
 * {@link Proxy} instances for all {@link Local} annotated interfaces.
 * 
 * @author Nicholas Blair
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(LateBindingLocalProxyConfiguration.class)
@Documented
public @interface EnableLateBindingLocalProxies {

	/**
	 * Alias for {@link #basePackages()} attribute.
	 */
	String[] value() default {};
	
	/**
	 * Base packages to scan for annotated components.
	 * <p>{@link #value()} is an alias for (and mutually exclusive with) this attribute.
	 */
	String[] basePackages() default {};
}
