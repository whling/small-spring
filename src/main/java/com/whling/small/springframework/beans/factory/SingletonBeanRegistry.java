package com.whling.small.springframework.beans.factory;

/**
 * @author whling
 */
public interface SingletonBeanRegistry {

    void registerSingleton(String name, Object singletonObj);

    Object getSingleton(String name);

    void registerDisposableBean(String name, DisposableBean bean);

    void destroySingletons();
}
