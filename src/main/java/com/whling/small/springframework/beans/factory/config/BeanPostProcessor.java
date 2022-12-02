package com.whling.small.springframework.beans.factory.config;

import com.whling.small.springframework.beans.BeansException;

/**
 * @author whling
 */
public interface BeanPostProcessor {

    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
