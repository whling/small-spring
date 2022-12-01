package com.whling.small.springframework.core.io;

import com.whling.small.springframework.core.io.resources.ClassPathResource;
import com.whling.small.springframework.core.io.resources.FileSystemResource;
import com.whling.small.springframework.core.io.resources.Resource;
import com.whling.small.springframework.core.io.resources.UrlResource;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author whling
 */
public class DefaultResourceLoader implements ResourceLoader {

    @Override
    public Resource getResource(String location) {
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        } else {
            try {
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                return new FileSystemResource(location);
            }
        }
    }
}
