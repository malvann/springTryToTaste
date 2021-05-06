package com.customSpring.byBorisov.policeman;

public class AngryPoliceman implements Policeman {
    @Override
    public void removePeople() {
        System.out.println("Ща всех порешу!");
    }
}
