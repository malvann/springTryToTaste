package com.customSpring.byBorisov.configurator;

import com.customSpring.byBorisov.AppContext;

public interface ObjectConfigurator {
    void configure(Object o, AppContext context);
}
