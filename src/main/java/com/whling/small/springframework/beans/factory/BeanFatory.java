package com.whling.small.springframework.beans.factory;

import com.whling.small.springframework.beans.BeansException;

/**
 * @author whling
 */
public interface BeanFatory {

    Object getBean(String beanName) throws BeansException;

    Object getBean(String beanName, Object... args) throws BeansException;

    <T> T getBean(String beanName, Class<T> requiredType);
}
