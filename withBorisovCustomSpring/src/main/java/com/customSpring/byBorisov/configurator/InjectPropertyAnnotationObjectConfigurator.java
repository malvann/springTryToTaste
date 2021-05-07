package com.customSpring.byBorisov.configurator;

import com.customSpring.byBorisov.AppContext;
import com.customSpring.byBorisov.annotation.InjectProperty;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class InjectPropertyAnnotationObjectConfigurator implements ObjectConfigurator {
    private static Map<String, String> propMap;

    @SneakyThrows
    public InjectPropertyAnnotationObjectConfigurator(){
        String path = ClassLoader.getSystemClassLoader().getResource("application.properties").getPath();
        Stream<String> lines = new BufferedReader(new FileReader(path)).lines();
        propMap = lines.map(line -> line.split("=")).collect(toMap(arr -> arr[0], arr -> arr[1]));
    }

    @Override
    @SneakyThrows
    public void configure(Object o, AppContext context) {
        Class<?> implClass = o.getClass();
        for (Field field :implClass.getDeclaredFields()) {
            InjectProperty annotation = field.getAnnotation(InjectProperty.class);
            String value;
            if (annotation != null){
                if (annotation.value().isEmpty()) value = propMap.get(field.getName());
                else  value = propMap.get(annotation.value());
                field.setAccessible(true);
                field.set(o, value);
            }
        }
    }
}
