package com.whling.small.springframework.beans.factory.support;

import com.whling.small.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;

/**
 * @author whling
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private HashMap<String, Object> singletonObjects = new HashMap<>();

    @Override
    public void registerSingleton(String name, Object singletonObj) {
        singletonObjects.put(name, singletonObj);
    }

    @Override
    public Object getSingleton(String name) {
        return singletonObjects.get(name);
    }
}
