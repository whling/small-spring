package com.whling.small.springframework.core.io;

import com.whling.small.springframework.core.io.resources.Resource;

/**
 * @author whling
 */
public interface ResourceLoader {

    /**
     * Pseudo URL prefix for loading from the class path: "classpath:"
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
