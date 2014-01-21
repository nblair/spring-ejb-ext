/**
 * 
 */
package com.github.nblair.spring.ejb;

import java.lang.reflect.Proxy;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.ejb.Local;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;

/**
 * Subclass of {@link ClassPathBeanDefinitionScanner} that creates late binding {@link Proxy} instances
 * for each {@link Local} interface found. The {@link Proxy}s are registered in JNDI.
 * 
 * @author Nicholas Blair
 */
public class LocalProxyCreatingClassPathBeanDefinitionScanner extends
		ClassPathBeanDefinitionScanner implements ApplicationContextAware {

	private ApplicationContext applicationContext;
	/**
	 * 
	 * @param registry
	 */
	public LocalProxyCreatingClassPathBeanDefinitionScanner(
			BeanDefinitionRegistry registry) {
		super(registry, false);
		addIncludeFilter(new AnnotationTypeFilter(Local.class));
	}
	/*
	 * (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	@Override
	@Autowired
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	/**
	 * The super class' implementation of this method looks for concrete/independent classes.
	 * Since we are looking for {@link Local}, we want just interfaces.
	 * 
	 * (non-Javadoc)
	 * @see org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider#isCandidateComponent(org.springframework.beans.factory.annotation.AnnotatedBeanDefinition)
	 */
	@Override
	protected boolean isCandidateComponent(
			AnnotatedBeanDefinition beanDefinition) {
		return beanDefinition.getMetadata().isInterface();
	}

	@Override
	protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
		Set<BeanDefinitionHolder> beanDefinitions = new LinkedHashSet<BeanDefinitionHolder>();
		for (String basePackage : basePackages) {
			Set<BeanDefinition> candidates = findCandidateComponents(basePackage);
			for (BeanDefinition candidate : candidates) {
				ProxyFactory.getProxy(candidate.getClass(), new LateBindingProxyMethodInterceptor(this.applicationContext, candidate.getClass()));
				
			}
			
		}
		return beanDefinitions;
	}

	
}
