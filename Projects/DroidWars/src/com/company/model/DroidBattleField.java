package com.company.model;


import com.company.droids.Droid;

import java.util.Random;

public class DroidBattleField {
    Droid droid1;
    Droid droid2;

    public DroidBattleField() {
    }

    public DroidBattleField(Droid droid1, Droid droid2) {
        this.droid1 = droid1;
        this.droid2 = droid2;
    }

    public Droid getDroid1() {
        return droid1;
    }

    public void setDroid1(Droid droid1) {
        this.droid1 = droid1;
    }

    public Droid getDroid2() {
        return droid2;
    }

    public void setDroid2(Droid droid2) {
        this.droid2 = droid2;
    }

    public Droid fight() {
        Droid winner;
        Random rn = new Random();
        int chanceToAimIntoDroid;
        int round = 1;

        while (droid1.getBatteryLife() > 0 && droid2.getBatteryLife() > 0) {
            System.out.println(DroidConsoleView.ROUND_MSG+round);
            chanceToAimIntoDroid = rn.nextInt(100);
            if(rn.nextBoolean()) droid1.fly(); //If droid is lucky it can fly away before the attack
            if (chanceToAimIntoDroid > droid1.getVelocity()) {
                if (rn.nextBoolean()) droid2.useSuperPower(droid1); //if droid is lucky it can use super power before attack
                droid1.setBatteryLife(droid1.getBatteryLife() - droid2.getStrength());
                System.out.println(droid2.getDroidName() + DroidConsoleView.HIT_MSG + (droid1.getBatteryLife()) + DroidConsoleView.TO_MSG + droid1.getDroidName());
            } else {
                System.out.println(droid1.getDroidName()+DroidConsoleView.AVOID_MSG);
            }
            chanceToAimIntoDroid = rn.nextInt(100);
            if(rn.nextBoolean()) droid2.fly();
            if (chanceToAimIntoDroid > droid2.getVelocity()) {
                if (rn.nextBoolean()) droid1.useSuperPower(droid1);
                droid2.setBatteryLife(droid2.getBatteryLife() - droid1.getStrength());
                System.out.println(droid1.getDroidName()+DroidConsoleView.HIT_MSG+(droid2.getBatteryLife())+DroidConsoleView.TO_MSG+droid2.getDroidName());
            } else {
                System.out.println(droid2.getDroidName()+DroidConsoleView.AVOID_MSG);
            }
            round++;
        }
        if (droid1.getBatteryLife() > 0) {
            winner = droid1;
        } else if(droid2.getBatteryLife() > 0) {
            winner = droid2;
        } else {
            System.out.println(DroidConsoleView.DRAW_MSG);
            winner = null;
        }
        return winner;
    }

    @Override
    public String toString() {
        return "DroidBattleField{" +
                "droid1=" + droid1 +
                ", droid2=" + droid2 +
                '}';
    }
}
