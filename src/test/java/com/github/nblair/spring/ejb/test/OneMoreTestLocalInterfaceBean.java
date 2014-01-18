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
public class OneMoreTestLocalInterfaceBean implements OneMoreTestLocalInterface {

	/* (non-Javadoc)
	 * @see com.github.nblair.spring.ejb.test.OneMoreTestLocalInterface#getBaz()
	 */
	public String getBaz() {
		return "world";
	}

}
