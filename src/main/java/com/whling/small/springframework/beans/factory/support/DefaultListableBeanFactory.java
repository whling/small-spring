package com.whling.small.springframework.beans.factory.support;

import com.whling.small.springframework.beans.BeansException;
import com.whling.small.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.whling.small.springframework.beans.factory.config.BeanDefinition;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author whling
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory
        implements BeanDefinitionRegistry, ConfigurableListableBeanFactory {

    private HashMap<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    public BeanDefinition getBeanDefinition(String beanName) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new BeansException(String.format("No beans named %s is defined", beanName));
        }
        return beanDefinition;
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

    @Override
    public void preInstantiateSingletons() throws BeansException {
        Arrays.stream(getBeanDefinitionNames()).forEach(this::getBean);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        Set<String> beanDefinitionNames = beanDefinitionMap.keySet();
        return beanDefinitionNames.toArray(new String[0]);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        Map<String, T> ret = new HashMap<>();
        beanDefinitionMap.forEach((beanName, beanDefinition) -> {
            Class beanClass = beanDefinition.getBeanClass();
            if (type.isAssignableFrom(beanClass)) {
                ret.put(beanName, getBean(beanName, type));
            }
        });
        return ret;
    }
}
