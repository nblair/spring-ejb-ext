/**
 * 
 */
package com.github.nblair.spring.ejb.test;

import javax.ejb.Local;

/**
 * Another test {@link Local} interface.
 * 
 * @author Nicholas Blair
 */
@Local
public interface YetAnotherTestLocalInterface {

	/**
	 * 
	 * @return a {@link String}
	 */
	String getBar();
}
