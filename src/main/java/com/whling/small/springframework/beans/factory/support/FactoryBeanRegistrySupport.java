package com.whling.small.springframework.beans.factory.support;

import com.whling.small.springframework.beans.BeansException;
import com.whling.small.springframework.beans.factory.FactoryBean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author whling
 */
public class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry {

    private final Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<>();

    protected Object getCachedObjectForFactoryBean(String beanName) {
        Object obj = factoryBeanObjectCache.get(beanName);
        return obj != NULL_OBJECT ? obj : null;
    }

    protected Object getObjectForFactoryBean(FactoryBean factoryBean, String beanName) {
        if (factoryBean.isSingleton()) {
            Object obj = factoryBeanObjectCache.get(beanName);
            if (obj == null) {
                obj = doGetObjectForFactoryBean(factoryBean, beanName);
                factoryBeanObjectCache.put(beanName, obj != null ? obj : NULL_OBJECT);
            }
            // obj != NULL_OBJECT ? obj : null;
            return obj;
        } else {
            return doGetObjectForFactoryBean(factoryBean, beanName);
        }
    }

    private Object doGetObjectForFactoryBean(FactoryBean factoryBean, String beanName) {
        try {
            return factoryBean.getObject();
        } catch (Exception e) {
            throw new BeansException("FactoryBean throw exception on object[" + beanName + "]", e);
        }
    }
}
