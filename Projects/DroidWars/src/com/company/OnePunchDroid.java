/** @author: Andriy Moskalenko */
package com.company;

public class OnePunchDroid extends Droid {
    public OnePunchDroid() {
        this.strength = 98;
        this.velocity = 1;
        this.batteryLife = 1;
        this.droidName = "OnePunchDroid";
    }

    public void lifeSteal(Droid a){
        this.batteryLife = a.getBatteryLife();
        a.setBatteryLife(1);
    }

    public void speedSteal(Droid a){
        this.velocity = a.getVelocity();
        a.setVelocity(1);
    }
}
