package com.company.model;


import com.company.droids.Droid;


import java.util.Random;

public class DroidBattleField {
    private Droid droid1;
    private Droid droid2;
    private Droid winner;

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
        this.winner = null;
        this.droid1 = droid1;
    }

    public Droid getDroid2() {
        return droid2;
    }

    public void setDroid2(Droid droid2) {
        this.winner = null;
        this.droid2 = droid2;
    }

    public Droid getWinner() {
        return winner;
    }

    public String fight() {
        StringBuilder fightResults = new StringBuilder();
        Random rn = new Random();
        int chanceToAimIntoDroid;
        int round = 1;

        while (droid1.getBatteryLife() > 0 && droid2.getBatteryLife() > 0) {
            fightResults.append(BattleInformationView.ROUND_MSG+round+"\n");
            chanceToAimIntoDroid = rn.nextInt(100);
            if(rn.nextBoolean()) droid1.fly(); //If droid is lucky it can fly away before the attack
            if (chanceToAimIntoDroid > droid1.getVelocity()) {
                if (rn.nextBoolean()) droid2.useSuperPower(droid1); //if droid is lucky it can use super power before attack
                droid1.setBatteryLife(droid1.getBatteryLife() - droid2.getStrength());
                fightResults.append(droid2.getDroidName() + BattleInformationView.HIT_MSG + (droid1.getBatteryLife()) + BattleInformationView.TO_MSG + droid1.getDroidName()+"\n");
            } else {
                fightResults.append(droid1.getDroidName()+BattleInformationView.AVOID_MSG+"\n");
            }
            chanceToAimIntoDroid = rn.nextInt(100);
            if(rn.nextBoolean()) droid2.fly();
            if (chanceToAimIntoDroid > droid2.getVelocity()) {
                if (rn.nextBoolean()) droid1.useSuperPower(droid1);
                droid2.setBatteryLife(droid2.getBatteryLife() - droid1.getStrength());
                fightResults.append(droid1.getDroidName()+BattleInformationView.HIT_MSG+(droid2.getBatteryLife())+BattleInformationView.TO_MSG+droid2.getDroidName()+"\n");
            } else {
                fightResults.append(droid2.getDroidName()+BattleInformationView.AVOID_MSG+"\n");
            }
            round++;
        }
        if (droid1.getBatteryLife() > 0) {
            winner = droid1;
        } else if(droid2.getBatteryLife() > 0) {
            winner = droid2;
        } else {
            fightResults.append(BattleInformationView.DRAW_MSG);
            winner = null;
        }
        return fightResults.toString();
    }

    @Override
    public String toString() {
        return "DroidBattleField{" +
                "droid1=" + droid1 +
                ", droid2=" + droid2 +
                '}';
    }

    public boolean hasDroids() {
        return droid1 != null && droid2 != null;
    }
}
