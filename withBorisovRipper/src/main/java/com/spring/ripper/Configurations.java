package com.spring.ripper;

import com.spring.ripper.annotation.listener.PostProxyInvokerContextListener;
import com.spring.ripper.annotation.processor.InjectRandomIntAnnotationPostProcessor;
import com.spring.ripper.annotation.processor.ProfilingHandlerBeanPostProcessor;
import com.spring.ripper.quoter.QuoterImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configurations {
    @Bean
    QuoterImpl getQuoterImplBean(){
        QuoterImpl quoter = new QuoterImpl();
        quoter.setMessage("Hello!");
        return quoter;
    }

    @Bean
    InjectRandomIntAnnotationPostProcessor getInjectRandomIntAnnotationPostProcessorBean(){
        return new InjectRandomIntAnnotationPostProcessor();
    }

    @Bean
    ProfilingHandlerBeanPostProcessor getProfilingHandlerBeanPostProcessor(){
        return new ProfilingHandlerBeanPostProcessor();
    }

    @Bean
    PostProxyInvokerContextListener getPostProxyInvokerContextListener(){
        return new PostProxyInvokerContextListener();
    }
}
