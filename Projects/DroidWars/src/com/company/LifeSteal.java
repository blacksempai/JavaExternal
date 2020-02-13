/** @author: Andriy Moskalenko */
package com.company;

public class LifeSteal implements SuperPower {
    @Override
    public void useSuperPower(Droid thisDroid, Droid enemy) {
        thisDroid.setBatteryLife(enemy.getBatteryLife());
        enemy.setBatteryLife(1);
    }
}
