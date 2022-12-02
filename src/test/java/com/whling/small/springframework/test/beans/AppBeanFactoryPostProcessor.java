package com.whling.small.springframework.test.beans;

import com.whling.small.springframework.beans.BeansException;
import com.whling.small.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.whling.small.springframework.beans.factory.config.BeanDefinition;
import com.whling.small.springframework.beans.factory.config.BeanFactoryPostProcessor;
import com.whling.small.springframework.beans.factory.config.PropertyValue;
import com.whling.small.springframework.beans.factory.config.PropertyValues;

/**
 * @author whling
 */
public class AppBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition userServiceDefinition = beanFactory.getBeanDefinition("userService");

        PropertyValues propertyValues = userServiceDefinition.getPropertyValues();

        propertyValues.getPropertyValue("serviceName")
                .ifPresent(propertyValue ->
                        propertyValues.addPropertyValue(
                                new PropertyValue("serviceName",
                                        propertyValue.getValue() + ".BeanFactoryPostProcessor")));
    }
}
