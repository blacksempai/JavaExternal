/** @author: Andriy Moskalenko */
package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("In catch block.");
            return null;
        }
    }

    public String[] authentication(){
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] loginAndPassword = new String[2];
        try {
            System.out.println("Enter your login:");
            loginAndPassword[0] = in.readLine();
            System.out.println("Enter your password:");
            loginAndPassword[1] = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("In catch block.");
            return null;
        }
        return loginAndPassword;
    }

    public String[] registration(){
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{6,}";
        Matcher match;
        String[] loginAndPassword = new String[2];
        try {
            do System.out.println("Enter your desirable login:");
            while (!(loginAndPassword[0] = in.readLine()).matches(pattern));

            do System.out.println("Enter your desirable password:");
            while (!(loginAndPassword[1] = in.readLine()).matches(pattern));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("In catch block.");
            return null;
        }
        return loginAndPassword;
    }

    public void authenticationResults(boolean success){
        if (success) System.out.println("Successful authentication!!");
        else System.out.println("Authentication is failed");
    }

    public void registrationResults(boolean success){
        if (success) System.out.println("Successful registration!!");
        else System.out.println("Registration is failed");
    }
}
