package com.whling.small.springframework.beans.factory;

/**
 * @author whling
 */
public interface InitializingBean {

    String METHOD_NAME = "afterPropertiesSet";

    void afterPropertiesSet() throws Exception;
}
