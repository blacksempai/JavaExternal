/** @author: Andriy Moskalenko */
package com.company;

public class OnePunchDroid extends Droid {
    public OnePunchDroid() {
        this.setStrength(98);
        this.setVelocity(1);
        this.setBatteryLife(1);
        this.setDroidName("OnePunchDroid");
        speedSteal();
    }

    public void lifeSteal(){
       setSuperPower(new LifeSteal());
    }

    public void speedSteal(){
        setSuperPower(new SpeedSteal());
    }
}
