package org.example.config.configurator;

import org.example.context.ApplicationContext;

public interface ObjectConfigurator {
    void configure(Object t, ApplicationContext context);

}
