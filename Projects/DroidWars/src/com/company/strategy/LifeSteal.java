/** @author: Andriy Moskalenko */
package com.company.strategy;

import com.company.droids.Droid;
import com.company.strategy.SuperPower;

import java.io.Serializable;

public class LifeSteal implements SuperPower, Serializable {
    @Override
    public void useSuperPower(Droid thisDroid, Droid enemy) {
        thisDroid.setBatteryLife(enemy.getBatteryLife());
        enemy.setBatteryLife(1);
    }
}
