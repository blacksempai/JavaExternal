/** @author: Andriy Moskalenko */
package com.company.strategy;

import com.company.droids.Droid;

public class HealPower implements SuperPower {
    @Override
    public void useSuperPower(Droid thisDroid, Droid enemy) {
        thisDroid.setBatteryLife(thisDroid.getBatteryLife()+25);
    }
}
