package com.customSpring.byBorisov.configurator;

import com.customSpring.byBorisov.annotation.InjectByType;
import com.customSpring.byBorisov.AppContext;
import lombok.SneakyThrows;

import java.lang.reflect.Field;

public class InjectByTypeAnnotationObjectConfigurator implements ObjectConfigurator {
    @Override
    @SneakyThrows
    public void configure(Object o, AppContext context) {
        for (Field field: o.getClass().getDeclaredFields()){
            if (!field.isAnnotationPresent(InjectByType.class)) return;
            field.setAccessible(true);
            Object o1 = context.getObject(field.getType());
            field.set(o, o1);
        }
    }
}
