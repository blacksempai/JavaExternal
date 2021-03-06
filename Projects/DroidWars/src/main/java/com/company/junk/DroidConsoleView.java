/** @author: Andriy Moskalenko */
package com.company.junk;

import com.company.droids.Droid;
import com.company.model.DroidTypes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DroidConsoleView {

    public void printResults(boolean result, Droid droid1, Droid droid2){
        if (result){
            System.out.println("The winner of war between of droid " + droid1.getDroidName() +
                    " and droid " + droid2.getDroidName() + " is the: \n" + droid1.getDroidName() + " !!! Congratulations!" );
        } else{
            System.out.println("The winner of war between of droid " + droid1.getDroidName() +
                    " and droid " + droid2.getDroidName() + " is the: \n" + droid2.getDroidName() + " !!! Congratulations!" );
        }
    }

    public DroidTypes userInput(){
        System.out.println("Enter droid type:");
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String input = in.readLine();
            if(input.equals("SPEEDY")) return DroidTypes.SPEEDY;
            if(input.equals("ONEPUNCH")) return DroidTypes.ONEPUNCH;
            if(input.equals("RANDOM")) return DroidTypes.RANDOM;
            if(input.equals("TANKY")) return DroidTypes.TANKY;
            System.out.println("There are no such droid, please try again");
            return userInput();
        }
        catch (IOException e){
            System.out.println("In catch block.");
            return null;
        }
    }
}
