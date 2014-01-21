package com.github.nblair.spring.ejb;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;

/**
 * 
 * @author Nicholas Blair
 */
@Configuration
public class LateBindingLocalProxyConfiguration {

	@Role(BeanDefinition.ROLE_INFRASTRUCTURE)
	@Bean
	public LocalProxyCreatingClassPathBeanDefinitionScanner beanDefinitionScanner(BeanDefinitionRegistry registry) {
		return new LocalProxyCreatingClassPathBeanDefinitionScanner(registry);
	}
}
