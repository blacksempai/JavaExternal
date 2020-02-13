package com.company;

public class SpeedSteal implements SuperPower {
    @Override
    public void useSuperPower(Droid thisDroid, Droid enemy) {
        thisDroid.setVelocity(enemy.getVelocity());
        enemy.setVelocity(1);
    }
}
