package com.whling.small.springframework.beans.factory;

import com.whling.small.springframework.beans.BeansException;

/**
 * @author whling
 */
public interface FactoryBean<T> {

    T getObject() throws BeansException;

    Class<?> getObjectType();

    boolean isSingleton();
}
