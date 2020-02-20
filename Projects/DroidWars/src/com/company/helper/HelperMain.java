package com.company.helper;

import com.company.droids.Droid;

import java.util.Arrays;

public class HelperMain {
    public static void main(String[] args) {
        DroidsShip ship = new DroidsShip();

        System.out.println("ShipTesting:");
        ship.fillShipWithDroids();
        Droid onepunch = ship.findDroidByName("OnePunchDroid");
        System.out.println("Finding OnePunchDroid in ship:");
        System.out.println(onepunch);
        System.out.println("Unsorted:");
        System.out.println(ship.getDeathStar());
        System.out.println("Sorted by strength:");
        ship.sortByStrength();
        System.out.println(ship.getDeathStar());
        System.out.println("Group by fly ability:");
        System.out.println(ship.groupByFlyAbility().getDeathStar());
    }
}
