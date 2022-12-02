package com.whling.small.springframework.beans.factory;

import com.whling.small.springframework.beans.BeansException;
import com.whling.small.springframework.beans.factory.config.BeanDefinition;

/**
 * @author whling
 */
public interface ConfigurableListableBeanFactory
        extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;
}
