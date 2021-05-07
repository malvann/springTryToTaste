package com.customSpring.byBorisov.configurator;

public interface ProxyConfigurator {
    Object replaceWithProxy(Object o, Class implClass);
}
