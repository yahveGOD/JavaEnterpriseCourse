package org.example.factory;

import lombok.Getter;
import lombok.SneakyThrows;
import org.example.annotations.AutoWire;
import org.example.annotations.Component;
import org.example.config.Config;
import org.example.config.configurator.ObjectConfigurator;
import org.example.context.ApplicationContext;
import org.reflections.Reflections;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

import static java.util.stream.Collectors.toMap;

public class ObjectFactory {
    @Getter
    private Map<Class,Object> map = new HashMap<>();
    private Config config;
    private final String CONFIGURATORS_FILEPATH = "org.example.config.configurator";
    private List<ObjectConfigurator> configurators = new ArrayList<>();


    @SneakyThrows
    public ObjectFactory(Config config,String packageToScan) {
        this.config = config;
        for (Class<? extends ObjectConfigurator> aClass : new Reflections(CONFIGURATORS_FILEPATH).getSubTypesOf(ObjectConfigurator.class))
            configurators.add(aClass.getDeclaredConstructor().newInstance());
        createBeans(packageToScan);
    }
    @SneakyThrows
    public <T> T createObject(Class<T> implClass) {
        T t = create(implClass);
        configure(t);
        return t;
    }

    private <T> void configure(T t) {
        configurators.forEach(objectConfigurator -> objectConfigurator.configure(t,map));
    }

    @SneakyThrows
    private <T> T create(Class<T> implClass) {
        if(implClass.getDeclaredConstructors().length == 1 && Arrays.stream(implClass.getDeclaredConstructors()).iterator().next().getParameterTypes().length == 0)
            return implClass.getDeclaredConstructor().newInstance();

        Constructor<?> constructor = Arrays.stream(implClass.getDeclaredConstructors()).iterator().next();
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        Object[] parameters = new Object[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++)
            parameters[i] = map.get(parameterTypes[i]);

        return (T) constructor.newInstance(parameters);
    }
    private void createBeans(String packageToScan)
    {
        List<Class> types = scanClasses(packageToScan);
        for (Class<?> type : types) {
            if (type.isInterface() && config.getImplClass(type).isAnnotationPresent(Component.class)) {
                    Object t = createObject(config.getImplClass(type));
                    map.putIfAbsent(type, t);
            } else {
                if (config.getImplClass(type).isAnnotationPresent(Component.class) && !map.containsKey(createObject(config.getImplClass(type)))) {
                    Object t = createObject(type);
                    map.putIfAbsent(type, t);
                }
            }
        }
        List<List<Class>> list = new ArrayList<>();
        for (Class clas: findStartClass()
             ) {
            list.add(findRootsOfClassesWithNullFields(clas,new ArrayList<>()));
        }
        for (List<Class> classes : list)
        {
            Collections.reverse(classes);
            classes.forEach(x ->map.replace(x,createObject(map.get(x).getClass())));
        }
        for(Map.Entry<Class,Object> entry : map.entrySet())
        {
            if(entry.getKey().isInterface())
            {
                configure(entry.getValue());
            }
        }
    }
    public static List<Class> scanClasses(String packageName) {
        List<Class> classes = new ArrayList<>();
        String packagePath = packageName.replace('.', '/');
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL packageUrl = classLoader.getResource(packagePath);

        if (packageUrl != null) {
            File packageDir = new File(packageUrl.getFile());
            if (packageDir.isDirectory()) {
                scanClassesRecursively(packageName, packageDir, classes);
            }
        }

        return classes;
    }

    private static void scanClassesRecursively(String packageName, File dir, List<Class> classes) {
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                scanClassesRecursively(packageName + "." + file.getName(), file, classes);
            } else if (file.getName().endsWith(".class")) {
                String className = packageName + "." + file.getName().replace(".class", "");
                try {
                    Class clazz = Class.forName(className);
                    classes.add(clazz);
                } catch (ClassNotFoundException e) {
                }
            }
        }
    }

    @SneakyThrows
    private List<Class> findRootsOfClassesWithNullFields(Class clazz, List<Class> classes){
        classes.add(config.getImplClass(clazz));

        for(Field field : clazz.getDeclaredFields()){
            field.setAccessible(true);

            if(map.containsKey(field.getType()))
                findRootsOfClassesWithNullFields(config.getImplClass(field.getType()), classes);
        }
        return classes;
    }

    private List<Class> findStartClass()
    {
        List<Class> classes = new ArrayList<>();
        for (Map.Entry<Class,Object> entryMap : map.entrySet()) {
            classes.addAll(findRootsOfClassesWithNullFields(entryMap.getKey(), new ArrayList<>()));
        }
        Map<Class, Integer> mapCounter = new HashMap<>();
        for(Class clazz : classes)
        {
            mapCounter.put(clazz,mapCounter.getOrDefault(clazz,0)+1);
        }
        List<Map.Entry<Class,Integer>> sortedEntries = new ArrayList<>(mapCounter.entrySet());
        sortedEntries.sort(Map.Entry.comparingByValue());
        List<Class> singleUseClasses = new ArrayList<>();
        for(Map.Entry<Class,Integer> entry : sortedEntries)
        {
            if(entry.getValue() == 1)
            {
                singleUseClasses.add(entry.getKey());
            }
        }
        return singleUseClasses;
    }
}


