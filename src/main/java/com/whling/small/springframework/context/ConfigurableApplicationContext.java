package com.whling.small.springframework.context;

import com.whling.small.springframework.beans.BeansException;

/**
 * @author whling
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    void refresh() throws BeansException;
}
