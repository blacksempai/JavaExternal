/** @author: Andriy Tyshkovets */
package com.company;

public class TankyDroid extends Droid {

    private int shield;

    public TankyDroid() {
        this.setStrength(35);
        this.setVelocity(5);
        this.setBatteryLife(60);
        this.setDroidName("TankyDroid");
        this.shield=100;
        heal();
    }

    @Override
    public int getBatteryLife(){
        return super.getBatteryLife()+shield;
    }

    public void heal(){
        setSuperPower(new HealPower());
    }

}
