/** @author: Andriy Moskalenko */
package com.company.strategy;

import com.company.droids.Droid;
import com.company.strategy.SuperPower;

public class LifeSteal implements SuperPower {
    @Override
    public void useSuperPower(Droid thisDroid, Droid enemy) {
        thisDroid.setBatteryLife(enemy.getBatteryLife());
        enemy.setBatteryLife(1);
    }
}
