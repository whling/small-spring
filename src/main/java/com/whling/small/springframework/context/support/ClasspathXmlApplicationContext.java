package com.whling.small.springframework.context.support;

/**
 * @author whling
 */
public class ClasspathXmlApplicationContext extends AbstractXmlApplicationContext {

    private String[] configLocations;

    public ClasspathXmlApplicationContext(String configLocation) {
        this(new String[]{configLocation});
    }

    public ClasspathXmlApplicationContext(String[] configLocations) {
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }
}
