/**
 * 
 */
package com.github.nblair.spring.ejb.test;

import javax.ejb.Local;

/**
 * Test interface annotated with {@link Local}.
 * 
 * @author Nicholas Blair
 */
@Local
public interface TestLocalInterface {

	/**
	 * 
	 * @return a {@link String}
	 */
	String getFoo();
}
