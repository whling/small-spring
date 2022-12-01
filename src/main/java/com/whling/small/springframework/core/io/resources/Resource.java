package com.whling.small.springframework.core.io.resources;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author whling
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
