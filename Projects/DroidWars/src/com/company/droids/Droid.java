/** @author: Radomyr Mykolenko*/
package com.company.droids;

import com.company.strategy.CantFly;
import com.company.strategy.Flyable;
import com.company.strategy.NoSuperPower;
import com.company.strategy.SuperPower;

import java.util.Objects;

public class Droid {
    private int strength;
    private int velocity;
    private int batteryLife;
    private String droidName;
    private Flyable flyable = new CantFly();
    private SuperPower superPower = new NoSuperPower();

    public Droid(int strength, int velocity, int batteryLife, String droidName) {
        this.strength = strength;
        this.velocity = velocity;
        this.batteryLife = batteryLife;
        this.droidName = droidName;
    }

    public Droid() {
    }

    public Flyable getFlyable() { return flyable; }

    public void setFlyable(Flyable flyable) { this.flyable = flyable; }

    public SuperPower getSuperPower() { return superPower; }

    public void setSuperPower(SuperPower superPower) { this.superPower = superPower; }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public void setBatteryLife(int batteryLife) {
        this.batteryLife = batteryLife;
    }

    public void setDroidName(String droidName) { this.droidName = droidName; }

    public int getStrength() {
        return strength;
    }

    public int getVelocity() {
        return velocity;
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    public String getDroidName() {
        return droidName;
    }

    public void fly(){
        flyable.fly(this);
    }

    public void useSuperPower(Droid enemy){
        superPower.useSuperPower(this, enemy);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Droid droid = (Droid) o;
        return droidName.equals(droid.droidName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(droidName);
    }

    public void displayInfo(){
        System.out.println("Droid name is:" + this.getDroidName());
        System.out.println("Strength: " + this.getStrength());
        System.out.println("Velocity: " + this.getVelocity());
        System.out.println("Battery Life: " + this.getBatteryLife());
        System.out.println(" ");
    };
}
