package com.company.helper;

import com.company.droids.Droid;
import com.company.droids.OnePunchDroid;
import com.company.droids.SpeedyDroid;
import com.company.droids.TankyDroid;

import java.io.*;
import java.util.ArrayList;

public class Serializator {
    String file_for_serialization = "src/com/company/helper/serialized_droids.data";
    String file_for_List_serialization = "src/com/company/helper/serialized_list_of_droids.data";

    public boolean serialization(Droid droid){

        boolean flag = false;
        File file = new File(file_for_serialization);
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fos = new FileOutputStream(file);
            if (fos!=null) {oos = new ObjectOutputStream(fos);
                oos.writeObject(droid);
                flag = true;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;

    }

    public boolean listOfDroidsSerialization(ArrayList<Droid> list){

        boolean flag = false;
        File file = new File(file_for_List_serialization);
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fos = new FileOutputStream(file);
            if (fos!=null) {oos = new ObjectOutputStream(fos);
                oos.writeObject(list);
                flag = true;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;

    }

    public Droid deserialization() throws Exception{

        File file = new File(file_for_serialization);
        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            if(fis!=null){
                ois = new ObjectInputStream(fis);
                Droid droid = (Droid) ois.readObject();
                return droid;
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        throw new InvalidObjectException("Object failed");
    }

    public ArrayList<Droid> ListOfDroidsDeserialization() throws Exception{

        File file = new File(file_for_List_serialization);
        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            if(fis!=null){
                ois = new ObjectInputStream(fis);
                ArrayList<Droid> list = (ArrayList<Droid>) ois.readObject();
                return list;
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        throw new InvalidObjectException("Object failed");
    }
}
