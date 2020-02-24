package com.company.helper;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class WritingToFile {
    public void writetofile(String path, String content) {
        FileWriter fwr = null;
        //System.out.println("It is writting to file " + path);

        try {
            fwr = new FileWriter(path, true);//true - можна дописувати
            fwr.write(content);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }finally {
            try {
                fwr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
