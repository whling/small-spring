package com.whling.small.springframework.context.support;

import com.whling.small.springframework.beans.BeansException;
import com.whling.small.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.whling.small.springframework.beans.factory.config.BeanFactoryPostProcessor;
import com.whling.small.springframework.beans.factory.config.BeanPostProcessor;
import com.whling.small.springframework.context.ConfigurableApplicationContext;
import com.whling.small.springframework.core.io.DefaultResourceLoader;

import java.util.Map;

/**
 * @author whling
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    @Override
    public void refresh() throws BeansException {
        refreshBeanFactory();
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        invokeBeanFactoryPostProcessors(beanFactory);

        registerBeanPostProcessors(beanFactory);

        beanFactory.preInstantiateSingletons();
    }

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap
                = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        beanFactoryPostProcessorMap.values()
                .forEach(beanFactoryPostProcessor -> beanFactoryPostProcessor.postProcessBeanFactory(beanFactory));
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        beanPostProcessorMap.values().forEach(beanFactory::addBeanPostProcessor);
    }


    protected abstract void refreshBeanFactory() throws BeansException;

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public Object getBean(String beanName) throws BeansException {
        return getBeanFactory().getBean(beanName);
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return getBeanFactory().getBean(beanName, args);
    }

    @Override
    public <T> T getBean(String beanName, Class<T> requiredType) {
        return getBeanFactory().getBean(beanName, requiredType);
    }
}
