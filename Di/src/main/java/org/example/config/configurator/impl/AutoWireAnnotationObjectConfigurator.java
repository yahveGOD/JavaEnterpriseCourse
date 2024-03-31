package org.example.config.configurator.impl;

import lombok.SneakyThrows;
import org.example.annotations.AutoWire;
import org.example.config.configurator.ObjectConfigurator;
import org.example.context.ApplicationContext;

import java.lang.reflect.Field;
import java.util.Map;

public class AutoWireAnnotationObjectConfigurator implements ObjectConfigurator {
    @SneakyThrows
    @Override
    public void configure(Object t, Map<Class,Object> map) {
        for (Field field : t.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(AutoWire.class)) {
                field.setAccessible(true);
                Object object = map.get(field.getType());
                field.set(t, object);
            }
        }
    }
}
