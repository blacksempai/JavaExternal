package com.company.strategy;

import com.company.droids.Droid;
import com.company.strategy.SuperPower;

import java.io.Serializable;

public class SpeedSteal implements SuperPower, Serializable {
    @Override
    public void useSuperPower(Droid thisDroid, Droid enemy) {
        thisDroid.setVelocity(enemy.getVelocity());
        enemy.setVelocity(1);
    }
}
