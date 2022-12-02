package com.whling.small.springframework.beans.factory;

import com.whling.small.springframework.beans.BeansException;

/**
 * @author whling
 */
public interface AutowireCapableBeanFactory extends BeanFatory {

    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;
}
