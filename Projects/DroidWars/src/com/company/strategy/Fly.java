/** @author: Andriy Moskalenko */
package com.company.strategy;

import com.company.droids.Droid;

public class Fly implements Flyable {
    @Override
    public void fly(Droid thisDroid) {
        if(thisDroid.getBatteryLife()>5) {
            thisDroid.setVelocity(thisDroid.getVelocity() + 20);
            thisDroid.setBatteryLife(thisDroid.getBatteryLife() - 5);
        }
    }
}
