package org.example.config.configurator;

import org.example.context.ApplicationContext;

import java.util.Map;

public interface ObjectConfigurator {
    void configure(Object t, Map<Class,Object> map);

}
