package org.example.config.configurator.impl;

import lombok.SneakyThrows;
import org.example.annotations.AutoWire;
import org.example.config.configurator.ObjectConfigurator;
import org.example.context.ApplicationContext;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AutoWireSetterObjectConfigurator implements ObjectConfigurator {
    @Override
    @SneakyThrows
    public void configure(Object t, ApplicationContext context) {
        for (Method method : t.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(AutoWire.class) && method.getName().startsWith("set") && method.getParameters().length == 1) {
                method.setAccessible(true);
                Object param = context.getObject(method.getParameterTypes()[0]);
                method.invoke(t,param);
            }
        }
    }
}
