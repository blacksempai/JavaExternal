/** @author: RadomyrMykolenko */
package com.company;

public class SpeedyDroid extends Droid {
    public SpeedyDroid(int strength, int velocity, int batteryLife, String droidName) {
        super(strength, velocity, batteryLife, droidName);
        this.setStrength(10);
        this.setVelocity(80);
        this.setBatteryLife(10);
    }

    @Override
    public int getBatteryLife(){
        return super.getBatteryLife()+90;
    }
}