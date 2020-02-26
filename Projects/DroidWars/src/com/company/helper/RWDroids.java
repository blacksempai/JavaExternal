package com.company.helper;

import com.company.droids.Droid;

import java.io.*;
import java.util.Arrays;

public class RWDroids {
    public static String filepath = "src/com/company/helper/droids.csv";

    public RWDroids() throws IOException {
    }

    public static void writeToFile(Droid []droids) throws IOException {
        PrintWriter writer =new PrintWriter(new FileWriter(filepath));
        for (Droid droid:droids) {
            writer.write(droid.toString2()+"\r\n");
        }
        writer.flush();
        writer.close();
    }

   public static Droid [] readFromFileDroids () throws IOException {
        BufferedReader reader =new BufferedReader(new FileReader(filepath));
        Droid [] droids = new Droid[3];
        String str ="";
        int i= 0;
        while((str = reader.readLine())!=null){
            String []elems = str.split(",");
            droids[i++]= createDroid(elems);
            //droids[i-1].displayInfo();
            //System.out.println(droids[i-1]);
        }
        return droids;
    }

    public static void DisplayReadedDroidsFromFile () {
        System.out.println("These droids were read from file " + filepath);
        Droid [] readeddroids = new Droid[3];
        try {
            readeddroids = readFromFileDroids();

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Droid droid: readeddroids) {
            System.out.println(droid);;
        }

    }

    public static Droid createDroid(String[] elems) {
        return  new Droid(Integer.parseInt(elems[1]), Integer.parseInt(elems[2]), Integer.parseInt(elems[3]), elems[0]);
        }
}
