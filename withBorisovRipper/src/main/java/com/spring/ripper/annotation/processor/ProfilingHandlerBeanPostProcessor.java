package com.spring.ripper.annotation.processor;

import com.spring.ripper.annotation.Profiling;
import com.spring.ripper.annotation.annotationController.ProfilingController;
import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Proxy;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.Map;

public class ProfilingHandlerBeanPostProcessor implements BeanPostProcessor {
    private static final Map<String, Class> map = new HashMap<>();
    private ProfilingController controller = new ProfilingController();

    @SneakyThrows
    public ProfilingHandlerBeanPostProcessor() {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        mBeanServer.registerMBean(controller, new ObjectName("profiling", "name", "Controller"));
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class beanClass = bean.getClass();
        if (beanClass.isAnnotationPresent(Profiling.class)) map.put(beanName, beanClass);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class beanClass = bean.getClass();
        if (beanClass == null) return bean;
        return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), (o, method, args) -> {
            if (controller.isEnable()) {
                long start = System.currentTimeMillis();
                System.out.println("start profiling...");
                Object retVal = method.invoke(bean, args);
                System.out.println(start - System.currentTimeMillis());
                System.out.println("end profiling...");
                return retVal;
            } else {
                return method.invoke(bean, args);
            }
        });
    }
}
