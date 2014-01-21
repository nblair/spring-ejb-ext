/**
 * 
 */
package com.github.nblair.spring.ejb;

import javax.ejb.Stateless;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;

/**
 * Target test {@link Configuration}.
 * 
 * @author Nicholas Blair
 */
@Configuration
@ComponentScan(
		basePackages="com.github.nblair.spring.ejb.test",
		includeFilters=@Filter(type=FilterType.ANNOTATION, value=Stateless.class))
public class TestConfiguration {

}
