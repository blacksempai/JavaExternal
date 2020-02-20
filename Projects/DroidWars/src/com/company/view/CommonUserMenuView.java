package com.company.view;

public class CommonUserMenuView {
    public final static String WHO_FIGHTS_MSG = "user.whoFights";
    public final static String CHOOSE_FIRST_DROID_MSG = "user.1d";
    public final static String CHOOSE_SECOND_DROID_MSG = "user.2d";
    public final static String WRONG_CHOOSE_MSG = "user.wrong";
    public final static String VICTORY_MSG = "user.won";
    public final static String LOST_MSG = "user.lost";
    public final static String WINNER_MSG = "user.winner";
    public final static String INVALID_CHOICE_MSG = "user.invalid";
    public final static String MENU_MSG = "user.menu";
    public final static String SET_BET_MSG = "user.bet";
    public final static String EXIT_MSG = "user.exit";
    public final static String NO_DROIDS_MSG = "user.noDroids";

    public void sendMsg(String str){
        System.out.println(str);
    }

}
