package com.whling.small.springframework.beans.factory;

/**
 * @author whling
 */
public interface BeanClassLoaderAware extends Aware {

    void setBeanClassLoader(ClassLoader classLoader);
}
