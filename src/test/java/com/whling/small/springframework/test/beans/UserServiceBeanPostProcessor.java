package com.whling.small.springframework.test.beans;

import com.whling.small.springframework.beans.BeansException;
import com.whling.small.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author whling
 */
public class UserServiceBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            System.out.println("do UserServiceBeanPostProcessor postProcessBeforeInitialization");
//            userService.setServiceName("UserServiceBeanPostProcessor update");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
