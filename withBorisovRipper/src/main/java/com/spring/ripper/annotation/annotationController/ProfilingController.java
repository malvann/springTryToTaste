package com.spring.ripper.annotation.annotationController;

import lombok.Setter;

@Setter
public class ProfilingController implements ProfilingControllerMBean{
    private boolean enable = true;

    public boolean isEnable(){
        return enable;
    }
}
