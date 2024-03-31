package org.example.context;

import lombok.Getter;
import lombok.Setter;
import org.example.annotations.Component;
import org.example.config.Config;
import org.example.factory.ObjectFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Component
public class ApplicationContext {
    @Setter
    private Map<Class,Object> cache = new ConcurrentHashMap<>();

    private static ApplicationContext context;
    public static ApplicationContext newApplicationContext()
    {
        if(context == null)
        {
            context = new ApplicationContext();
        }
        return context;

    }
    private ApplicationContext() {

    }

    public <T> T getObject(Class<T> type) {
        return (T) cache.get(type);
    }

}
