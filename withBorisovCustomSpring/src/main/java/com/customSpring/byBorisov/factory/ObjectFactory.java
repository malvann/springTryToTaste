package com.customSpring.byBorisov.factory;

import com.customSpring.byBorisov.AppContext;
import com.customSpring.byBorisov.annotation.PostConstract;
import com.customSpring.byBorisov.configurator.ObjectConfigurator;
import com.customSpring.byBorisov.configurator.ProxyConfigurator;
import lombok.SneakyThrows;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ObjectFactory {
    private final AppContext context;
    private List<ObjectConfigurator> configurators = new ArrayList<>();
    private List<ProxyConfigurator> proxyConfigurators = new ArrayList<>();

    @SneakyThrows
    public ObjectFactory(AppContext context){
        this.context = context;
        for (Class<? extends ObjectConfigurator> aClass: context.getConfig().getScanner().getSubTypesOf(ObjectConfigurator.class)) {
            configurators.add(aClass.getDeclaredConstructor().newInstance());
        }
        for (Class<? extends ProxyConfigurator> aClass: context.getConfig().getScanner().getSubTypesOf(ProxyConfigurator.class)) {
            proxyConfigurators.add(aClass.getDeclaredConstructor().newInstance());
        }
    }

    @SneakyThrows
    public <T> T createObject(Class<T> implClass) {
        T t = create(implClass);
        configure(t);
        invokeInit(implClass, t);
        t = wrapWithProxyIfNeed(implClass, t);
        return t;
    }

    private <T> T wrapWithProxyIfNeed(Class<T> implClass, T t) {
        for (ProxyConfigurator configurator : proxyConfigurators) t = (T) configurator.replaceWithProxy(t, implClass);
        return t;
    }

    private <T> void invokeInit(Class<T> implClass, T t) throws IllegalAccessException, InvocationTargetException {
        for (Method method: implClass.getMethods()) {
            if (method.isAnnotationPresent(PostConstract.class)) method.invoke(t);
        }
    }

    private <T> void configure(T t) {
        configurators.forEach(objectConfigurator -> objectConfigurator.configure(t, context));
    }

    private <T> T create(Class<T> implClass) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        T t = implClass.getDeclaredConstructor().newInstance();
        return t;
    }


}
