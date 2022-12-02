package com.whling.small.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.whling.small.springframework.beans.BeansException;
import com.whling.small.springframework.beans.factory.AutowireCapableBeanFactory;
import com.whling.small.springframework.beans.factory.config.BeanDefinition;
import com.whling.small.springframework.beans.factory.config.BeanPostProcessor;
import com.whling.small.springframework.beans.factory.config.BeanReference;
import com.whling.small.springframework.beans.factory.config.PropertyValue;
import com.whling.small.springframework.beans.factory.config.PropertyValues;

import java.lang.reflect.Constructor;

/**
 * @author whling
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Object bean;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
            applyPropertyValues(bean, beanDefinition, beanName);

            bean = initializeBean(bean, beanName, beanDefinition);
        } catch (Exception e) {
            throw new BeansException(String.format("Instantiation of beans failed, beanName is [%s]", beanName), e);
        }
        super.registerSingleton(beanName, bean);
        return bean;
    }

    private Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructorToUse = null;
        Class clazz = beanDefinition.getBeanClass();
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            if (args != null && declaredConstructor.getParameterTypes().length == args.length) {
                constructorToUse = declaredConstructor;
                break;
            }
        }

        return instantiationStrategy.instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    private void applyPropertyValues(Object bean, BeanDefinition beanDefinition, String beanName) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {

                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                if (value instanceof BeanReference) {
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }
    }

    private Object initializeBean(Object bean, String beanName, BeanDefinition beanDefinition) {

        Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(bean, beanName);

        invokeInitMethods(beanName, wrappedBean, beanDefinition);

        wrappedBean = applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);

        return wrappedBean;
    }

    private void invokeInitMethods(String beanName, Object wrappedBean, BeanDefinition beanDefinition) {

    }

    @Override
    public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor postProcessor : getBeanPostProcessors()) {
            Object current = postProcessor.postProcessBeforeInitialization(result, beanName);
            if (current == null) {
                break;
            }
            result = current;
        }
        return result;
    }

    @Override
    public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor postProcessor : getBeanPostProcessors()) {
            Object current = postProcessor.postProcessAfterInitialization(result, beanName);
            if (current == null) {
                break;
            }
            result = current;
        }
        return result;
    }
}
