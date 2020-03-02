package com.company.helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFromFile {
    public void readfromfile(String path) {
        FileInputStream fis = null; //побайотово записує
        int b = 0;
        try {
            fis = new FileInputStream(path);
            System.out.println("Showing the content of file " + path);
            while ((b = fis.read()) != -1) {
                System.out.print((char) b);
            }
            System.out.println();
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
        } catch (
                IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
