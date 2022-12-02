package com.whling.small.springframework.beans.factory;

import com.whling.small.springframework.beans.BeansException;

import java.util.Map;

/**
 * @author whling
 */
public interface ListableBeanFactory extends BeanFatory {

    String[] getBeanDefinitionNames();

    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;
}
