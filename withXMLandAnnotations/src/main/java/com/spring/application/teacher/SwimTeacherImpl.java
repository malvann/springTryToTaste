package com.spring.application.teacher;

import org.apache.log4j.Logger;

public class SwimTeacherImpl implements Teacher{
    public static final Logger LOGGER = Logger.getLogger(SwimTeacherImpl.class);

    @Override
    public void teach() {
        LOGGER.info("SWIM LIKE A FISH!");
    }
}
