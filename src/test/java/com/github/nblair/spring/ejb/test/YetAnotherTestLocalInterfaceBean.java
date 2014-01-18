/**
 * 
 */
package com.github.nblair.spring.ejb.test;

import javax.ejb.Stateless;

/**
 * @author Nicholas Blair
 *
 */
@Stateless
public class YetAnotherTestLocalInterfaceBean implements
		YetAnotherTestLocalInterface {

	/* (non-Javadoc)
	 * @see com.github.nblair.spring.ejb.test.YetAnotherTestLocalInterface#getBar()
	 */
	public String getBar() {
		return "hello";
	}

}
