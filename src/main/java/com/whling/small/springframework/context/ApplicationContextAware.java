package com.whling.small.springframework.context;

import com.whling.small.springframework.beans.BeansException;
import com.whling.small.springframework.beans.factory.Aware;

/**
 * @author whling
 */
public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
