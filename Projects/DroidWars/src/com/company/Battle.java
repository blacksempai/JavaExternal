/** @author: Radomyr Mykolenko*/

package com.company;

public class Battle {
    public boolean warOfTwoDroids(Droid droid1, Droid droid2){
        int strengthDelta = droid1.getStrength() - droid2.getStrength();
        int batteryLifeDelta = droid1.getBatteryLife() - droid2.getBatteryLife();
        int velocityDelta = droid1.getVelocity() - droid2.getVelocity();
        int scoreDroid1 = 0;
        int scoreDroid2 = 0;

        if (strengthDelta > 0){
            scoreDroid1++;
        } else if (strengthDelta < 0){
            scoreDroid2++;
        }

        if (batteryLifeDelta > 0){
            scoreDroid1++;
        } else if (batteryLifeDelta < 0){
            scoreDroid2++;
        }

        if (velocityDelta > 0){
            scoreDroid1++;
        } else if (velocityDelta < 0){
            scoreDroid2++;
        }

        // отримання результату
        return scoreDroid1>scoreDroid2;
        }
    }

