package org.example;

import org.example.config.JavaConfig;
import org.example.context.ApplicationContext;
import org.example.factory.ObjectFactory;

import java.util.HashMap;
import java.util.Map;

public class Applicaton {
    public static ApplicationContext run(String packageToScan)
    {
        JavaConfig config = new JavaConfig(packageToScan, new HashMap<Class, Class>());
            ApplicationContext context = new ApplicationContext(config);
            ObjectFactory factory = new ObjectFactory(context);
            context.setFactory(factory);
            return context;

    }
}
