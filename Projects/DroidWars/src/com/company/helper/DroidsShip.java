package com.company.helper;

import com.company.droids.Droid;
import com.company.strategy.Fly;
import com.company.strategy.NoSuperPower;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DroidsShip {
    List<Droid> deathStar = new ArrayList<Droid>();
    RandomDroidGenerator random = new RandomDroidGenerator();
    int size = 20;

    public void addDroid(Droid droid){
        deathStar.add(droid);
    }

    public void fillShipWithDroids(){
        for (int i = 0; i < size; i++) {
            deathStar.add(random.nextDroid());
        }
    }

    public void fillShipWithDroids(int size){
        this.size = size;
        for (int i = 0; i < size; i++) {
            deathStar.add(random.nextDroid());
        }
    }

    public DroidsShip groupByFlyAbility(){
        DroidsShip ship = new DroidsShip();
        for (Droid droid : deathStar) {
            if (droid.getFlyable() instanceof Fly)
                ship.addDroid(droid);
        }
        return ship;
    }

    public DroidsShip groupBySuperPower(){
        DroidsShip ship = new DroidsShip();
        for (Droid droid : deathStar) {
            if (droid.getSuperPower() instanceof NoSuperPower)
                ship.addDroid(droid);
        }
        return ship;
    }

    public void sortByStrength(){
        deathStar.sort((d1, d2) ->  d2.getStrength() - d1.getStrength());
    }

    public void sortByVelocity(){
        deathStar.sort((d1, d2) ->  d2.getVelocity() - d1.getVelocity());
    }

    public void sortByBatteryLife(){
        deathStar.sort((d1, d2) ->  d2.getBatteryLife() - d1.getBatteryLife());
    }

    public Droid findDroidByName(String name){
        for (Droid droid: deathStar) {
            if(droid.getDroidName().equals(name))
                return droid;
        }
        return null;
    }

    public List<Droid> getDeathStar() {
        return deathStar;
    }
}
