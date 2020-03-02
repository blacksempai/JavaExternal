/** @author: Andriy Moskalenko */
package com.company.junk;

import com.company.droids.Droid;
import com.company.junk.Battle;
import com.company.model.DroidFactory;
import com.company.model.DroidTypes;

public class DroidModel {
    DroidFactory factory;
    Battle battle;

    public DroidModel() {
        this.factory = new DroidFactory();
        this.battle = new Battle();
    }

    public DroidModel(DroidFactory factory, Battle battle) {
        this.factory = factory;
        this.battle = battle;
    }

    public DroidFactory getFactory() {
        return factory;
    }

    public void setFactory(DroidFactory factory) {
        this.factory = factory;
    }

    public Battle getBattle() {
        return battle;
    }

    public void setBattle(Battle battle) {
        this.battle = battle;
    }

    public boolean preformBattle(DroidTypes a, DroidTypes b){
        return battle.warOfTwoDroids(factory.getDroid(a), factory.getDroid(b));
    }

    public Droid getDroid(DroidTypes droidType){
        return factory.getDroid(droidType);
    }
}
