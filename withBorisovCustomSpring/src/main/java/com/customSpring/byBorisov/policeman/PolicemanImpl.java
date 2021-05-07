package com.customSpring.byBorisov.policeman;

import com.customSpring.byBorisov.recomendator.Recomendator;
import com.customSpring.byBorisov.annotation.InjectByType;
import com.customSpring.byBorisov.annotation.PostConstract;

public class PolicemanImpl implements Policeman{
    @InjectByType
    private Recomendator recomendator;

    @PostConstract
    public void init() {
        System.out.println(recomendator.getClass());
    }

    @Override
    public void removePeople() {
        System.out.println("GO! GO! GO! GO!");
    }
}
