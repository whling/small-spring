package com.whling.small.springframework.beans.factory.config;

/**
 * @author whling
 */
public interface SingletonBeanRegistry {

    void registerSingleton(String name, Object singletonObj);

    Object getSingleton(String name);
}
