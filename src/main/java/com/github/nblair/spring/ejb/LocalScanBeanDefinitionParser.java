/**
 * 
 */
package com.github.nblair.spring.ejb;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.beans.factory.xml.XmlReaderContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * 
 * @author Nicholas Blair
 */
public class LocalScanBeanDefinitionParser implements BeanDefinitionParser {

	private Log log = LogFactory.getLog(this.getClass());
	
	private static final String BASE_PACKAGE_ATTRIBUTE = "base-package";
	
	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.xml.BeanDefinitionParser#parse(org.w3c.dom.Element, org.springframework.beans.factory.xml.ParserContext)
	 */
	public BeanDefinition parse(Element element, ParserContext parserContext) {
		String[] basePackages = StringUtils.tokenizeToStringArray(element.getAttribute(BASE_PACKAGE_ATTRIBUTE),
				ConfigurableApplicationContext.CONFIG_LOCATION_DELIMITERS);
		
		XmlReaderContext readerContext = parserContext.getReaderContext();
		LocalProxyCreatingClassPathBeanDefinitionScanner scanner = new LocalProxyCreatingClassPathBeanDefinitionScanner(readerContext.getRegistry());
		int beans = scanner.scan(basePackages);
		if(log.isDebugEnabled()) {
			log.debug("registered " + beans + " within basePackages=" + Arrays.toString(basePackages));
		}
		return null;
	}

}
