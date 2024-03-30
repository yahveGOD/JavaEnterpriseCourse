package org.example;

import org.example.config.JavaConfig;
import org.example.context.ApplicationContext;
import org.example.factory.ObjectFactory;

import java.util.HashMap;
import java.util.Map;

public class Applicaton {
    public static ApplicationContext run(String packageToScan)
    {
            JavaConfig config = new JavaConfig(packageToScan);
            ApplicationContext context = ApplicationContext.newApplicationContext();
            ObjectFactory factory = new ObjectFactory(config,packageToScan);
            context.setCache(factory.getMap());
            return context;
    }
}
