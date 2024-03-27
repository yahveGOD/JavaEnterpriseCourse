package org.example.config.configurator.impl;

import lombok.SneakyThrows;
import org.example.annotations.AutoWire;
import org.example.config.configurator.ObjectConfigurator;
import org.example.context.ApplicationContext;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class AutoWireConstructorObjectConfigurator implements ObjectConfigurator {
    @Override
    @SneakyThrows
    public void configure(Object t, ApplicationContext context) {
            for (Constructor constructor : t.getClass().getDeclaredConstructors()) {
                if (constructor.isAnnotationPresent(AutoWire.class)) {
                    constructor.setAccessible(true);
                    Class<?>[] parameterTypes = constructor.getParameterTypes();
                    Object[] parameters = new Object[parameterTypes.length];
                    for (int i = 0; i < parameterTypes.length; i++) {
                        parameters[i] = context.getObject(parameterTypes[i]);
                    }
                    constructor.newInstance(parameters);
                    break;
                }
            }
    }
}
