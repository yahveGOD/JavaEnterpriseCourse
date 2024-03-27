package org.example.factory;

import lombok.SneakyThrows;
import org.example.annotations.AutoWire;
import org.example.config.configurator.ObjectConfigurator;
import org.example.context.ApplicationContext;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toMap;

public class ObjectFactory {
    private static ObjectFactory objectFactory;
    private final ApplicationContext context;
    private List<ObjectConfigurator> configurators = new ArrayList<>();

    @SneakyThrows
    public ObjectFactory(ApplicationContext context) {
        this.context = context;
        for (Class<? extends ObjectConfigurator> aClass : context.getConfig().getScanner().getSubTypesOf(ObjectConfigurator.class)) {
            configurators.add(aClass.getDeclaredConstructor().newInstance());
        }
    }

    @SneakyThrows
    public <T> T createObject(Class<T> implClass) {

        T t = create(implClass);
        configure(t);
        return t;
    }

    private <T> void configure(T t) {
        configurators.forEach(objectConfigurator -> objectConfigurator.configure(t,context));
    }

    @SneakyThrows
    private <T> T create(Class<T> implClass) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        if(implClass.getDeclaredConstructors().length == 1 && Arrays.stream(implClass.getDeclaredConstructors()).iterator().next().getParameterTypes().length == 0) {
            T t = implClass.getDeclaredConstructor().newInstance();
        }
                Constructor<?> constructor = Arrays.stream(implClass.getDeclaredConstructors()).iterator().next();
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                Object[] parameters = new Object[parameterTypes.length];
                for (int i = 0; i < parameterTypes.length; i++) {
                    parameters[i] = context.getObject(parameterTypes[i]);
                }
                constructor.newInstance(parameters);

        return (T) constructor.newInstance(parameters);
    }
}
