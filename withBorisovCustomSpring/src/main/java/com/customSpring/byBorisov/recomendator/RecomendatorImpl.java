package com.customSpring.byBorisov.recomendator;

import com.customSpring.byBorisov.annotation.InjectProperty;
import com.customSpring.byBorisov.annotation.Singleton;

@Singleton
@Deprecated
public class RecomendatorImpl implements Recomendator {
    @InjectProperty("whisky")
    private String liquid;

    public RecomendatorImpl() {
        System.out.println("-- recomendator was created --");
    }

    @Override
    public void recommend() {
        System.out.println("To protect u, drink " + liquid);
    }
}
