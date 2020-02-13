/** @author: RadomyrMykolenko */
package com.company;

public class SpeedyDroid extends Droid {
    public SpeedyDroid() {
        this.setStrength(10);
        this.setVelocity(80);
        this.setBatteryLife(10);
        this.setDroidName("speedy");
        setFlyable(new Fly());
    }

    @Override
    public int getBatteryLife(){
        return super.getBatteryLife()+90;
    }

}