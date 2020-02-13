/** @author: Andriy Moskalenko */
package com.company;

public class HealPower implements SuperPower {
    @Override
    public void useSuperPower(Droid thisDroid, Droid enemy) {
        thisDroid.setBatteryLife(thisDroid.getBatteryLife()+25);
    }
}
