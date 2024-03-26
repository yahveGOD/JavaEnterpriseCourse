package org.example.context;

import lombok.Getter;
import lombok.Setter;
import org.example.annotations.Component;
import org.example.config.Config;
import org.example.factory.ObjectFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApplicationContext {
    @Setter
    private ObjectFactory factory;
    private Map<Class,Object> cache = new ConcurrentHashMap<>();
    @Getter
    private Config config;

    public ApplicationContext(Config config) {

        this.config = config;
    }

    public <T> T getObject(Class<T> type)
    {
        if(cache.containsKey(type))
        {
            T t = (T) cache.get(type);
            return t;
        }
        Class<? extends T> implClass = type;
        if (type.isInterface()) {
            implClass = config.getImplClass(type);
        }
        T t = factory.createObject(implClass);
        if(implClass.isAnnotationPresent(Component.class))
        {
            cache.put(type,t);
        }
        return t;
    }
}
