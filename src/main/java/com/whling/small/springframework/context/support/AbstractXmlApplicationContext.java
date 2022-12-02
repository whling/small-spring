package com.whling.small.springframework.context.support;

import com.whling.small.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.whling.small.springframework.beans.factory.support.XmlBeanDefinitionReader;

/**
 * @author whling
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        xmlBeanDefinitionReader.loadBeanDefinitions(getConfigLocations());
    }

    protected abstract String[] getConfigLocations();
}
