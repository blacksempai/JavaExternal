package com.company.strategy;

import com.company.droids.Droid;
import com.company.strategy.SuperPower;

public class SpeedSteal implements SuperPower {
    @Override
    public void useSuperPower(Droid thisDroid, Droid enemy) {
        thisDroid.setVelocity(enemy.getVelocity());
        enemy.setVelocity(1);
    }
}
