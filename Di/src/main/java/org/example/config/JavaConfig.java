package org.example.config;

import lombok.Getter;
import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;

public class JavaConfig implements Config {
    @Getter
    private Reflections scanner;
    private Map<Class,Class> ifc2implclass;

    public JavaConfig(String packageToScan,Map<Class,Class> ifc2implclass) {
        this.ifc2implclass = ifc2implclass;
        this.scanner = new Reflections(packageToScan);
    }

    @Override
    public <T> Class<? extends T> getImplClass(Class<T> ifc) {
       return ifc2implclass.computeIfAbsent(ifc,aClass ->{
        Set<Class<? extends T>> classes = scanner.getSubTypesOf(ifc);
        if (classes.size() != 1) {
            throw new RuntimeException(ifc + "has 0 or more than one impl, please update your config");
        }

        return classes.iterator().next();
       });
    }
}
