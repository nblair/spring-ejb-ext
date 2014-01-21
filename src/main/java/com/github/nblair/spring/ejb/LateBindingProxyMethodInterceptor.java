/**
 * 
 */
package com.github.nblair.spring.ejb;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

/**
 * @author Nicholas Blair
 */
public class LateBindingProxyMethodInterceptor implements MethodInterceptor {

	private final ApplicationContext applicationContext;
	private final Class<?> targetInterface;
	private volatile Object bean;
	
	public LateBindingProxyMethodInterceptor(
			ApplicationContext applicationContext, Class<?> targetInterface) {
		this.applicationContext = applicationContext;
		this.targetInterface = targetInterface;
	}


	/* (non-Javadoc)
	 * @see org.aopalliance.intercept.MethodInterceptor#invoke(org.aopalliance.intercept.MethodInvocation)
	 */
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		if(bean == null) {
			// try to load
			
			
		} else {
			// invoke the method on bean
			
		}
		
		return invocation.proceed();
	}

	Object locateBean() {
		try {
			return this.applicationContext.getBean(targetInterface);
		} catch (BeansException e) {
			return null;
		}
	}
}
