package com.whling.small.springframework.beans.factory.support;

import com.whling.small.springframework.beans.BeansException;
import com.whling.small.springframework.beans.factory.ConfigurableBeanFactory;
import com.whling.small.springframework.beans.factory.config.BeanDefinition;
import com.whling.small.springframework.beans.factory.config.BeanPostProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author whling
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {

    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    @Override
    public Object getBean(String beanName) throws BeansException {
        return doGetBean(beanName, null);
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return doGetBean(beanName, args);
    }

    @Override
    public <T> T getBean(String beanName, Class<T> requiredType) {
        return (T) getBean(beanName);
    }

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        beanPostProcessors.add(beanPostProcessor);
    }

    @Override
    public List<BeanPostProcessor> getBeanPostProcessors() {
        return beanPostProcessors;
    }

    private Object doGetBean(String beanName, Object... args) {
        Object bean = getSingleton(beanName);
        if (bean != null) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName, beanDefinition, args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName);

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args);

}
