package com.company.helper;

import com.company.droids.Droid;
import com.company.droids.OnePunchDroid;
import com.company.droids.SpeedyDroid;
import com.company.droids.TankyDroid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class HelperMain {
    public static void main(String[] args) throws IOException {
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

        //сериалізація + десериалізація

        Serializator serialize = new Serializator();

        ArrayList<Droid> listOfDroids = new ArrayList<Droid>();
        listOfDroids.add(new TankyDroid());
        listOfDroids.add(new OnePunchDroid());
        listOfDroids.add(new SpeedyDroid());
        serialize.listOfDroidsSerialization(listOfDroids);

        try {
            ArrayList<Droid> list = (ArrayList<Droid>) serialize.ListOfDroidsDeserialization();
            for (Droid elements : list){
                elements.displayInfo();
            }
            System.out.println("Deserialization was succesful");
        } catch (Exception e) {
            e.printStackTrace();
        }

        String path = "src/com/company/helper/info_about_droids.csv";
        WritingToFile wtf = new WritingToFile();
        for (Droid elements : listOfDroids){
            wtf.writetofile(path, elements.getDroidName() + ",");
            wtf.writetofile(path, elements.getStrength() + ",");
            wtf.writetofile(path, elements.getVelocity() + ",");
            wtf.writetofile(path, elements.getBatteryLife() + ",\n");
        }
        ReadFromFile rff = new ReadFromFile();
        rff.readfromfile(path);

        Droid [] ArraylistOfDroids = {new TankyDroid(),new OnePunchDroid(),new SpeedyDroid()};
        RWDroids.writeToFile(ArraylistOfDroids);
        RWDroids.readFromFileDroids();
    }
}
