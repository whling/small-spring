package com.whling.small.springframework.test.beans;

import com.whling.small.springframework.beans.BeansException;
import com.whling.small.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.whling.small.springframework.beans.factory.config.BeanDefinition;
import com.whling.small.springframework.beans.factory.config.BeanFactoryPostProcessor;
import com.whling.small.springframework.beans.factory.config.PropertyValue;
import com.whling.small.springframework.beans.factory.config.PropertyValues;
import com.whling.small.springframework.context.ApplicationContext;
import com.whling.small.springframework.context.ApplicationContextAware;

/**
 * @author whling
 */
public class AppBeanFactoryPostProcessor implements BeanFactoryPostProcessor, ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("1. do setApplicationContext before postProcessBeanFactory");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("2. do postProcessBeanFactory");

        BeanDefinition userServiceDefinition = beanFactory.getBeanDefinition("userService");

        PropertyValues propertyValues = userServiceDefinition.getPropertyValues();

        propertyValues.getPropertyValue("serviceName")
                .ifPresent(propertyValue ->
                        propertyValues.addPropertyValue(
                                new PropertyValue("serviceName",
                                        propertyValue.getValue() + ".BeanFactoryPostProcessor")));
    }
}
