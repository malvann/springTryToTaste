package com.customSpring.byBorisov.entity;

import com.customSpring.byBorisov.annotation.InjectByType;
import com.customSpring.byBorisov.announcer.Announser;
import com.customSpring.byBorisov.policeman.Policeman;

@Deprecated
public class Desinfector {
    @InjectByType
    Announser announcer;
    @InjectByType
    Policeman policemen;

    public void start(Room room){
        announcer.announce("Disinfection will be started in 60 sec. Go out.");
        policemen.removePeople();
        disinfect(room);
        announcer.announce("Room is disinfected. Come in.");
    }

    private void disinfect(Room room){
        System.out.println(room + " DISINFECTING IN PROCEED!");
    }
}
