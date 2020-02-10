package com.company;

public class Droid {
    private int strength;
    private int velocity;
    private int batteryLife;
    private String droidType;

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public void setBatteryLife(int batteryLife) {
        this.batteryLife = batteryLife;
    }

    public void setDroidType(String droidType) {
        this.droidType = droidType;
    }

    public int getStrength() {
        return strength;
    }

    public int getVelocity() {
        return velocity;
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    public String getDroidType() {
        return droidType;
    }

    public Droid(String name) {
        switch (name){
            case "slowpoke":{
                this.droidType = "slowpoke";
                this.strength = 20;
                this.velocity = 10;
                this.batteryLife = 70;
            };
            case "speedy":{
                this.droidType = "speedy";
                this.strength = 15;
                this.velocity = 70;
                this.batteryLife = 15;
            }
            /*default:{
                System.out.println("Warning! Such type of droid doesn't exist");
            }*/
        }

    }
    public void displayInfo(){
        System.out.println("Droid type is:" + this.getDroidType());
        System.out.println("Strength: " + this.getStrength());
        System.out.println("Velocity: " + this.getVelocity());
        System.out.println("Battery Life: " + this.getBatteryLife());
        System.out.println(" ");
    };
}
