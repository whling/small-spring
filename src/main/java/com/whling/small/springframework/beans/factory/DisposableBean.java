package com.whling.small.springframework.beans.factory;

/**
 * @author whling
 */
public interface DisposableBean {

    String DESTROY_METHOD_NAME = "destroy";

    void destroy() throws Exception;
}
