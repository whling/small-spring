package com.whling.small.springframework.test.beans;

import com.whling.small.springframework.beans.BeansException;
import com.whling.small.springframework.beans.factory.BeanNameAware;
import com.whling.small.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author whling
 */
public class UserServiceBeanPostProcessor implements BeanPostProcessor, BeanNameAware {

    @Override
    public void setBeanName(String beanName) throws BeansException {
        System.out.println("3. UserServiceBeanPostProcessor beanName is " + beanName);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            System.out.println("9. do UserServiceBeanPostProcessor postProcessBeforeInitialization");
//            userService.setServiceName("UserServiceBeanPostProcessor update");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
