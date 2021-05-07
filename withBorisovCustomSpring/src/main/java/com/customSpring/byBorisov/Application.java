package com.customSpring.byBorisov;

import com.customSpring.byBorisov.config.JavaConfig;
import com.customSpring.byBorisov.factory.ObjectFactory;

import java.util.Map;

public class Application {
    public static AppContext run(String packageToScan, Map<Class, Class> ifc2ImplClass){
        JavaConfig config = new JavaConfig(packageToScan, ifc2ImplClass);
        AppContext context = new AppContext(config);
        ObjectFactory factory = new ObjectFactory(context);
        context.setFactory(factory);
        //add auto init all Singletons
        return context;
    }
}
