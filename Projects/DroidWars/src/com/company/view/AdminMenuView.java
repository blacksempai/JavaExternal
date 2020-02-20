package com.company.view;

import com.company.model.DroidTypes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AdminMenuView {
    protected final static String MENU_MSG = "Choose what you want to do";
    protected final static String MAKE_A_BATTLE_MSG = "Make a battle of two droids - 1";
    protected final static String DELETE_MSG = "Delete droid from the battlefield - 2";
    protected final static String WHICH_TO_DELETE_MSG = "Which droid you want to delete";
    protected final static String DELETED_SUCCESSFULLY_MSG = "Droid deleted";
    protected final static String WHICH_TO_CHANGE_MSG = "Choose droid you want to change";
    protected final static String CHANGE_MSG = "Change droid on the battlefield - 3";
    protected final static String ADD_MSG = "Add droid to the battlefield - 4";
    protected final static String WHICH_TO_ADD_MSG = "Choose droid you want to add";
    protected final static String SEE_DROID_ON_BATTLEFIELD_MSG = "To look who is on the battlefield - 5";
    protected final static String СHOOSE_FIRST_DROID_FOR_ADDING_MSG = "Choose number of first droid you want to fight on the battlefield";
    protected final static String СHOOSE_SECOND_DROID_FOR_ADDING_MSG = "Choose number of second droid you want to fight on the battlefield";
    protected final static String INVALID_CHOICE_MSG = "Invalid choice, try again";
    protected final static String WINNER_MSG = "Winner is : ";
    protected final static String SPACE_MSG = "No space to add droid ";
    protected final static String DROIDS_ON_BATTLE_MSG = "This droids is on the battlefield right now : ";
    protected final static String NO_DROIDS_MSG = "No droid here ";
    protected final static String NO_DROIDS_TO_DELETE_MSG = "No droids to delete ";
    protected final static String NO_DROIDS_TO_CHANGE_MSG = "No droids to change ";
    protected final static String EXIT_MSG = "EXIT - 6 ";

    public void sendMsg(String str){
        System.out.println(str);
    }

    public void getMenu(){
        System.out.println(MENU_MSG);
        System.out.println(MAKE_A_BATTLE_MSG);
        System.out.println(DELETE_MSG);
        System.out.println(CHANGE_MSG);
        System.out.println(ADD_MSG);
        System.out.println(SEE_DROID_ON_BATTLEFIELD_MSG);
        System.out.println(EXIT_MSG);
    }

    public int getDroids() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(DroidTypes.ONEPUNCH + " - 1");
        System.out.println(DroidTypes.RANDOM + " - 2");
        System.out.println(DroidTypes.SPEEDY + " - 3");
        System.out.println(DroidTypes.SLOWPOKE + " - 4");
        System.out.println(DroidTypes.TANKY + " - 5");
        try {
            String select = br.readLine();
            switch (select) {
                case "1": {
                    return 1;
                }
                case "2": {
                    return 2;
                }
                case "3": {
                    return 3;
                }
                case "4": {
                    return 4;
                }
                case "5": {
                    return 5;
                }
                default: {
                    System.err.println(INVALID_CHOICE_MSG);
                    return 0;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
