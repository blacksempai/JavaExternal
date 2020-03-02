/** @author: Andriy Moskalenko */
package com.company.droids;

import com.company.droids.Droid;
import com.company.strategy.LifeSteal;
import com.company.strategy.SpeedSteal;

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
