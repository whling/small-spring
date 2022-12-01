package com.whling.small.springframework.beans.factory.support;

import com.whling.small.springframework.beans.factory.config.BeanDefinition;

/**
 * @author whling
 */
public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    boolean containsBeanDefinition(String beanName);
}
