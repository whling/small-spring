package com.whling.small.springframework.beans.factory.config;

import com.whling.small.springframework.beans.BeansException;
import com.whling.small.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @author whling
 */
public interface BeanFactoryPostProcessor {

    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
