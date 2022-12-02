package com.whling.small.springframework.context.support;

import com.whling.small.springframework.beans.BeansException;
import com.whling.small.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.whling.small.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author whling
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        loadBeanDefinitions(defaultListableBeanFactory);
        this.beanFactory = defaultListableBeanFactory;
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
