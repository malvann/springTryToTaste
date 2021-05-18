package com.spring.ripper.annotation.processor;

import com.spring.ripper.annotation.InjectRandomInt;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

public class InjectRandomIntAnnotationPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        for (Field field: bean.getClass().getDeclaredFields()){
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if (annotation == null) continue;
            int min = annotation.min();
            int max = annotation.max();
            int i = min + new Random().nextInt(max - min);
            field.setAccessible(true);
            ReflectionUtils.setField(field, bean, i);
        }
        return bean;
    }
}
