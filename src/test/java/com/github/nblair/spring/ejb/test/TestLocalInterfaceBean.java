/**
 * 
 */
package com.github.nblair.spring.ejb.test;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.NamingException;

import org.springframework.jndi.JndiTemplate;

/**
 * Implementation of {@link TestLocalInterface} that demonstrates the use case
 * for this library.
 * 
 * {@link YetAnotherTestLocalInterface} dependency is injected via {@link EJB}, whereas
 * the {@link OneMoreTestLocalInterface} dependency is retrieved via JNDI lookup.
 * 
 * @author Nicholas Blair
 */
@Stateless
public class TestLocalInterfaceBean implements TestLocalInterface {

	private YetAnotherTestLocalInterface yetAnother;
	private OneMoreTestLocalInterface oneMore;
	
	/**
	 * @param yetAnother
	 */
	@EJB
	public void setYetAnother(YetAnotherTestLocalInterface yetAnother) {
		this.yetAnother = yetAnother;
	}

	/**
	 * Retrieves the {@link OneMoreTestLocalInterface}
	 */
	@PostConstruct
	public void locateOneMore() {
		try {
			this.oneMore = (OneMoreTestLocalInterface) new JndiTemplate().lookup("java:/application/OneMoreTestLocalInterface");
		} catch (NamingException e) {
			throw new IllegalStateException("can't find OneMoreTestLocalInterface");
		}
	}

	/* (non-Javadoc)
	 * @see com.github.nblair.spring.ejb.test.TestLocalInterface#getFoo()
	 */
	public String getFoo() {
		return this.yetAnother.getBar() + " " +  this.oneMore.getBaz();
	}

}
