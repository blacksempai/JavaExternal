package com.company.helper;

import com.company.droids.Droid;
import com.company.model.DroidBattleField;

import static org.junit.jupiter.api.Assertions.*;

class DroidBattleFieldTest {


    @org.junit.jupiter.api.Test
    void getWinnerWinnerDroidVSLooserDroid() {
        Droid winner = new WinnerDroid();
        Droid loser = new LooserDroid();
        Droid expResult = winner;
        DroidBattleField droidBattleField = new DroidBattleField(winner,loser);
        droidBattleField.fight();
        Droid result = droidBattleField.getWinner();
        assertEquals(expResult,result);
    }

    @org.junit.jupiter.api.Test
    void hasDroidsWithOneDroid() {
        Droid winner = new WinnerDroid();
        Droid loser = new LooserDroid();
        Droid expResult = winner;
        DroidBattleField droidBattleField = new DroidBattleField(winner,loser);
        droidBattleField.setDroid1(null);
        boolean expectedResult = false;
        boolean actualResult = droidBattleField.hasDroids();
        assertEquals(expectedResult,actualResult);
    }
}