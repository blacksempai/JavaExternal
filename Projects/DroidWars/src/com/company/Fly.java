/** @author: Andriy Moskalenko */
package com.company;

public class Fly implements Flyable {
    @Override
    public void fly(Droid thisDroid) {
        if(thisDroid.getBatteryLife()>5) {
            thisDroid.setVelocity(thisDroid.getVelocity() + 50);
            thisDroid.setBatteryLife(thisDroid.getBatteryLife() - 5);
        }
    }
}
