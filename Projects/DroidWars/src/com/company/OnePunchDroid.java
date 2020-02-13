/** @author: Andriy Moskalenko */
package com.company;

public class OnePunchDroid extends Droid {
    public OnePunchDroid() {
        this.setStrength(98);
        this.setVelocity(1);
        this.setBatteryLife(1);
        this.setDroidName("OnePunchDroid");
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
