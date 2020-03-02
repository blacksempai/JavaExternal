/** @author: Radomyr Mykolenko*/
package com.company.droids;

import com.company.strategy.CantFly;
import com.company.strategy.Flyable;
import com.company.strategy.NoSuperPower;
import com.company.strategy.SuperPower;

import java.io.Serializable;
import java.util.Objects;

public class Droid implements Serializable {
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

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(this.getDroidName()).append(" ; ");
        sb.append("Strength: ").append(this.getStrength()).append(" ; ");
        sb.append("Velocity: ").append(this.getVelocity()).append(" ; ");
        sb.append("Battery Life: ").append(this.getBatteryLife()).append(" ; ");
        return sb.toString();
    };

    public String toString2(){
        return this.getDroidName() + "," + this.getStrength() + "," +
                this.getVelocity() + "," + this.getBatteryLife();
    }

    public static class Engine {
        String version = "v0.6";
        int energy = 25;

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public int getEnergy() {
            return energy;
        }

        public void setEnergy(int energy) {
            this.energy = energy;
        }
    }

    public void displayInfo(){
        System.out.println("Droid name is:" + this.getDroidName());
        System.out.println("Strength: " + this.getStrength());
        System.out.println("Velocity: " + this.getVelocity());
        System.out.println("Battery Life: " + this.getBatteryLife());
        System.out.println(" ");
    }
}
