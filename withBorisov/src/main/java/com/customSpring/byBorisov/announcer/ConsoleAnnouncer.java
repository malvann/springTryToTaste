package com.customSpring.byBorisov.announcer;

import com.customSpring.byBorisov.annotation.InjectByType;
import com.customSpring.byBorisov.recomendator.Recomendator;

public class ConsoleAnnouncer implements Announser{
    @InjectByType
    Recomendator recomendator;
    @Override
    public void announce(String msg) {
        System.out.println(msg);
        recomendator.recommend();
    }
}
