/** @author: Andriy Moskalenko */
package com.company;

public class OnePunchDroid extends Droid {
    public OnePunchDroid(int strength, int velocity, int batteryLife, String droidName) {
        super(strength, velocity, batteryLife, droidName);
        this.setStrength(98);
        this.setVelocity(1);
        this.setBatteryLife(1);
    }

    public void lifeSteal(Droid a){
        this.setBatteryLife(a.getBatteryLife());
        a.setBatteryLife(1);
    }

    public void speedSteal(Droid a){
        this.setVelocity(a.getVelocity());
        a.setVelocity(1);
    }
}
