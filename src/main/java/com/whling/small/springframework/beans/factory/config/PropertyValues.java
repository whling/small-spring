package com.whling.small.springframework.beans.factory.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author whling
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValues = new ArrayList<>();

    public void addPropertyValue(PropertyValue propertyValue) {
        propertyValues.add(propertyValue);
    }

    public List<PropertyValue> getPropertyValues() {
        return propertyValues;
    }

    public Optional<PropertyValue> getPropertyValue(String name) {
        return getPropertyValues()
                .stream()
                .filter(pv -> Objects.equals(pv.getName(), name))
                .findFirst();
    }
}
