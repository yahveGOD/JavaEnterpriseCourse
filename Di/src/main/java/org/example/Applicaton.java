package org.example;

import org.example.config.JavaConfig;
import org.example.context.ApplicationContext;
import org.example.factory.ObjectFactory;

import java.util.HashMap;
import java.util.Map;

public class Applicaton {
    private static boolean isRunExecuted = false;
    public static ApplicationContext run(String packageToScan)
    {
        if(!isRunExecuted) {
            JavaConfig config = new JavaConfig(packageToScan, new HashMap<Class, Class>());
            ApplicationContext context = new ApplicationContext(config);
            ObjectFactory factory = new ObjectFactory(context);
            context.setFactory(factory);
            isRunExecuted = true;
            return context;
        }
        else
        {
            throw new RuntimeException("This method have already been used");
        }

    }
}
