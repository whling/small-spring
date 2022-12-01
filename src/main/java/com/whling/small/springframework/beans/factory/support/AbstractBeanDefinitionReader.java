package com.whling.small.springframework.beans.factory.support;

import com.whling.small.springframework.beans.BeansException;
import com.whling.small.springframework.core.io.DefaultResourceLoader;
import com.whling.small.springframework.core.io.ResourceLoader;
import com.whling.small.springframework.core.io.resources.Resource;

import java.io.InputStream;
import java.util.Arrays;

/**
 * @author whling
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private final BeanDefinitionRegistry beanDefinitionRegistry;

    private final ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry) {
        this(beanDefinitionRegistry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry,
                                        ResourceLoader resourceLoader) {
        this.beanDefinitionRegistry = beanDefinitionRegistry;
        this.resourceLoader = resourceLoader;
    }


    @Override
    public BeanDefinitionRegistry getBeanDefinitionRegistry() {
        return beanDefinitionRegistry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try {
            try (InputStream in = resource.getInputStream()) {
                doLoadBeanDefinitions(in);
            }
        } catch (Exception e) {
            throw new BeansException("IOException parsing XML document from " + resource, e);
        }
    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
        Arrays.stream(resources).forEach(this::loadBeanDefinitions);
    }

    @Override
    public void loadBeanDefinitions(String... locations) {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource[] resources = Arrays.stream(locations)
                .map(resourceLoader::getResource)
                .toArray(Resource[]::new);
        loadBeanDefinitions(resources);

    }

    protected abstract void doLoadBeanDefinitions(InputStream in) throws Exception;
}
