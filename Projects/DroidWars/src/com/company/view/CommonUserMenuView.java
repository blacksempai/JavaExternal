package com.company.view;

public class CommonUserMenuView {
    protected final static String WHO_FIGHTS_MSG = "The battle between this droids. Select one of them : ";
    protected final static String CHOOSE_FIRST_DROID_MSG = "You have choose first droid";
    protected final static String CHOOSE_SECOND_DROID_MSG = "You have choose second droid";
    protected final static String WRONG_CHOOSE_MSG = "Something went wrong while you was choosing the droid. Try again";
    protected final static String VICTORY_MSG = "Your droid won!!!";
    protected final static String LOST_MSG = "Your droid lost :( ";
    protected final static String WINNER_MSG = "Winner is : ";
    protected final static String INVALID_CHOICE_MSG = "Invalid choice, try again";
    protected final static String MENU_MSG = "Choose what you want to do";
    protected final static String SET_BET_MSG = "To set bet - 1";
    protected final static String EXIT_MSG = "EXIT - 2";
    protected final static String NO_DROIDS_MSG = "There is only one droid, or no droids at all. You can't bet.";

    public void getMsg(String str){
        System.out.println(str);
    }

    public void getMenu(){
        System.out.println(MENU_MSG);
        System.out.println(SET_BET_MSG);
        System.out.println(EXIT_MSG);

    }


}
