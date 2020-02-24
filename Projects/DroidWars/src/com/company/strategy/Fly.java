/** @author: Andriy Moskalenko */
package com.company.strategy;

import com.company.droids.Droid;

import java.io.Serializable;

public class Fly implements Flyable, Serializable {
    @Override
    public void fly(Droid thisDroid) {
        if(thisDroid.getBatteryLife()>5) {
            thisDroid.setVelocity(thisDroid.getVelocity() + 20);
            thisDroid.setBatteryLife(thisDroid.getBatteryLife() - 5);
        }
    }
}
