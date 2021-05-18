package com.spring.application.teacher;

import org.apache.log4j.Logger;

public class SkiingTeacherImpl implements Teacher{
    public static final Logger LOGGER = Logger.getLogger(SkiingTeacherImpl.class);

    @Override
    public void teach() {
        LOGGER.info("Ski like a pinyin....");
    }
}
