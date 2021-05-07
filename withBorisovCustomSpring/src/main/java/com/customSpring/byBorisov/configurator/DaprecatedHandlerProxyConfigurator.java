package com.customSpring.byBorisov.configurator;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DaprecatedHandlerProxyConfigurator implements ProxyConfigurator {
    @Override
    public Object replaceWithProxy(Object o, Class implClass) {
        if (implClass.isAnnotationPresent(Deprecated.class)) {
            if (implClass.getInterfaces().length == 0){
                return Enhancer.create(implClass, (InvocationHandler) (proxy, method, args) -> {
                    return invokeLogic(o, method, args);
                });
            }

            return Proxy.newProxyInstance(implClass.getClassLoader(), implClass.getInterfaces(), (proxy, method, args) -> {
                return invokeLogic(o, method, args);
            });
        }
        return o;
    }

    private Object invokeLogic(Object o, Method method, Object[] args) throws IllegalAccessException, InvocationTargetException {
        System.out.println("*********** invocation: Deprecated annotation ***********");
        return method.invoke(o, args);
    }
}
