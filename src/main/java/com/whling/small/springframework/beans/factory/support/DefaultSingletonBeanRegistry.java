package com.whling.small.springframework.beans.factory.support;

import com.whling.small.springframework.beans.BeansException;
import com.whling.small.springframework.beans.factory.DisposableBean;
import com.whling.small.springframework.beans.factory.SingletonBeanRegistry;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author whling
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjects = new LinkedHashMap<>();

    private Map<String, DisposableBean> disposableBeans = new LinkedHashMap<>();

    @Override
    public void registerSingleton(String name, Object singletonObj) {
        singletonObjects.put(name, singletonObj);
    }

    @Override
    public Object getSingleton(String name) {
        return singletonObjects.get(name);
    }

    @Override
    public void registerDisposableBean(String name, DisposableBean bean) {
        disposableBeans.put(name, bean);
    }

    @Override
    public void destroySingletons() {
        Set<String> keySet = disposableBeans.keySet();

        Object[] disposableBeanNames = keySet.toArray();

        for (int i = disposableBeanNames.length -1 ; i >= 0 ; i--) {
            Object disposableBeanName = disposableBeanNames[i];

            DisposableBean disposableBean = disposableBeans.remove(disposableBeanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name '" + disposableBeanName + "' threw an exception", e);
            }
        }
    }
}
