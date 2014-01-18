/**
 * 
 */
package com.github.nblair.spring.ejb.test;

import javax.ejb.Local;

/**
 * One more test {@link Local} interface.
 * 
 * @author Nicholas Blair
 */
@Local
public interface OneMoreTestLocalInterface {

	/**
	 * 
	 * @return a {@link String}
	 */
	String getBaz();
}
