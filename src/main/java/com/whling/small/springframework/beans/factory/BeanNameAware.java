package com.whling.small.springframework.beans.factory;

import com.whling.small.springframework.beans.BeansException;

/**
 * @author whling
 */
public interface BeanNameAware extends Aware {

    void setBeanName(String beanName) throws BeansException;
}
