/**
 * 
 */
package com.github.nblair.spring.ejb;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.nblair.spring.ejb.test.OneMoreTestLocalInterface;
import com.github.nblair.spring.ejb.test.TestLocalInterface;
import com.github.nblair.spring.ejb.test.TestLocalInterfaceBean;

/**
 * Primary test case.
 * 
 * What should happen:
 * <ol>
 * <li>Spring classpath scans, looking for {@link Local} interfaces.</li>
 * <li>Spring creates late binding proxies for the found{@link Local} beans.</li>
 * <li>Each proxy is registered in JNDI.</li>
 * <li>Spring component scans, looking for our {@link Stateless} beans.</li>
 * <li>The proxies are notified and attach to the matching beans.</li>
 * </ol>
 * 
 * If those steps don't succeed:
 * <ul>
 * <li>{@link TestLocalInterfaceBean#locateOneMore()} will fail because the {@link OneMoreTestLocalInterface} isn't bound in JNDI.</li>
 * <li>If the JNDI lookup succeeds in locating the proxy for {@link OneMoreTestLocalInterface}, 
 * but the proxy never attaches to the real implementation, {@link #testFullyBound()} will fail since the 
 * proxy can't actually invoke the method.</li>
 * </ul>
 * 
 * @author Nicholas Blair
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestConfiguration.class)
public class TestCase {

	@Autowired
	private TestLocalInterface testLocalInterface;
	
	@Test
	public void testFullyBound() {
		assertEquals("hello world", testLocalInterface.getFoo());
	}
}
