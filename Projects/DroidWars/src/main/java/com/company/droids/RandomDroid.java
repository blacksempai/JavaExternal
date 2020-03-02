/** @author: Andriy Moskalenko */
package com.company.droids;

import com.company.strategy.Fly;

import java.util.Random;
//Should be fixed because causes exception situations
public class RandomDroid extends Droid {
    Random randomEngine = new Random();

    public RandomDroid() {
        this.setStrength(33);
        this.setVelocity(34);
        this.setBatteryLife(33);
        this.setDroidName("RandomDroid");
        setFlyable(new Fly());
    }

    @Override
    public int getStrength() {
        return randomEngine.nextBoolean() ? super.getStrength()*2 : 1;
    }

    @Override
    public int getVelocity() {
        return randomEngine.nextBoolean() ? super.getVelocity()*2 : 1;
    }

    @Override
    public int getBatteryLife() {
        return randomEngine.nextBoolean() ? super.getBatteryLife()*2 : 1;
    }
}
