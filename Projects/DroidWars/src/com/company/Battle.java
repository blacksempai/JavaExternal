/** @author: Radomyr Mykolenko*/

package com.company;

public class Battle {
    public void warOfTwoDroids(Droid droid1, Droid droid2){
        int strengthDelta = droid1.getStrength() - droid2.getStrength();
        int batteryLifeDelta = droid1.getBatteryLife() - droid2.getBatteryLife();
        int velocityDelta = droid1.getVelocity() - droid2.getVelocity();
        int result_strength_Droid1;
        int result_strength_Droid2;
        int result_batteryLife_Droid1;
        int result_batteryLife_Droid2;
        int result_velocity_Droid1;
        int result_velocity_Droid2;

        if (strengthDelta > 0){
            result_strength_Droid1 = 1;
            result_strength_Droid2 = 0;
        } else if (strengthDelta < 0){
                result_strength_Droid1 = 0;
                result_strength_Droid2 = 1;
        } else {
                result_strength_Droid1 = 0;
                result_strength_Droid2 = 0;
        };


        if (batteryLifeDelta > 0){
            result_batteryLife_Droid1 = 1;
            result_batteryLife_Droid2 = 0;
        } else if(batteryLifeDelta < 0){
                result_batteryLife_Droid1 = 0;
                result_batteryLife_Droid2 = 1;
        } else {
                result_batteryLife_Droid1 = 0;
                result_batteryLife_Droid2 = 0;
        };


        if (velocityDelta > 0){
            result_velocity_Droid1 = 1;
            result_velocity_Droid2 = 0;
        } else if(velocityDelta < 0){
                result_velocity_Droid1 = 0;
                result_velocity_Droid2 = 1;
        } else {
                result_velocity_Droid1 = 0;
                result_velocity_Droid2 = 0;
        };

        // отримання результату
        if ((result_batteryLife_Droid1 + result_strength_Droid1 + result_velocity_Droid1) >= 2){
            System.out.println("The winner of war between of droid " + droid1.getDroidType() +
                    " and droid " + droid2.getDroidType() + " is the: \n" + droid1.getDroidType() + " !!! Congratulations!" );
        } else if ((result_batteryLife_Droid1 + result_strength_Droid1 + result_velocity_Droid1) == 1){
                System.out.println("The winner of war between of droid " + droid1.getDroidType() +
                        " and droid " + droid2.getDroidType() + " is the: \n" + droid2.getDroidType() + " !!! Congratulations!" );
            } else {
            System.out.println("There is not a winner in the war between droids " + droid1.getDroidType() + " and " +
                    droid2.getDroidType() +", please try again!");
            };

        }

    }

