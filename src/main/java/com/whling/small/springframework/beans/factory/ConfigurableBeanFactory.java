package com.whling.small.springframework.beans.factory;

import com.whling.small.springframework.beans.factory.config.BeanPostProcessor;

import java.util.List;

/**
 * @author whling
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory {

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    List<BeanPostProcessor> getBeanPostProcessors();

    void destroySingletons();
}
