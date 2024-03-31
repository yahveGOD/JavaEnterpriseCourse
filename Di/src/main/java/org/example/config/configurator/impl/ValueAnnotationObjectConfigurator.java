package org.example.config.configurator.impl;

import lombok.SneakyThrows;
import org.example.annotations.Value;
import org.example.config.configurator.ObjectConfigurator;
import org.example.context.ApplicationContext;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class ValueAnnotationObjectConfigurator implements ObjectConfigurator {
    private final Map<String, String> propertiesMap;

    @SneakyThrows
    public ValueAnnotationObjectConfigurator() {
        URL resource = ClassLoader.getSystemClassLoader().getResource("org/example/application.properties");
        File file = Paths.get(resource.toURI()).toFile();
        String absolutePath = file.getAbsolutePath();
        Stream<String> lines = new BufferedReader(new FileReader(absolutePath)).lines();
        propertiesMap = lines.map(line -> line.split("=")).collect(toMap(arr -> arr[0], arr -> arr[1]));
    }

    @Override
    @SneakyThrows
    public void configure(Object t, Map<Class,Object> map) {
        Class<?> implClass = t.getClass();
        for (Field field : implClass.getDeclaredFields()) {
            Value annotation = field.getAnnotation(Value.class);
            if (annotation != null) {
                String value = annotation.value().isEmpty() ? propertiesMap.get(field.getName()) : propertiesMap.get(annotation.value());
                field.setAccessible(true);
                field.set(t, value);
            }

        }
    }
}
