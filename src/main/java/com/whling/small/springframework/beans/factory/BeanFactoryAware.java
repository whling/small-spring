package com.whling.small.springframework.beans.factory;

import com.whling.small.springframework.beans.BeansException;

/**
 * @author whling
 */
public interface BeanFactoryAware extends Aware {

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
