package com.customSpring.byBorisov;

import com.customSpring.byBorisov.entity.Desinfector;
import com.customSpring.byBorisov.entity.Room;
import com.customSpring.byBorisov.policeman.Policeman;
import com.customSpring.byBorisov.policeman.PolicemanImpl;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args){
        AppContext context = Application.run("com.customSpring.byBorisov", new HashMap<>(Map.of(Policeman.class, PolicemanImpl.class)));
        Desinfector desinfector = context.getObject(Desinfector.class);
        desinfector.start(new Room());
    }
}
