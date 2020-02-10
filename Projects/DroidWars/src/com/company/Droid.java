/** @author: Radomyr Mykolenko*/
package com.company;

public class Droid {
    private int strength;
    private int velocity;
    private int batteryLife;
    private String droidName;

    public Droid(int strength, int velocity, int batteryLife, String droidName) {
        this.strength = strength;
        this.velocity = velocity;
        this.batteryLife = batteryLife;
        this.droidName = droidName;
    }

    public Droid() {
    }

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

    public void displayInfo(){
        System.out.println("Droid name is:" + this.getDroidName());
        System.out.println("Strength: " + this.getStrength());
        System.out.println("Velocity: " + this.getVelocity());
        System.out.println("Battery Life: " + this.getBatteryLife());
        System.out.println(" ");
    };
}
