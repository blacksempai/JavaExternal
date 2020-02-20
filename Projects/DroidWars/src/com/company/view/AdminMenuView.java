package com.company.view;

import com.company.model.DroidTypes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AdminMenuView {
    public final static String MENU_MSG = "admin.menu";
    public final static String MAKE_A_BATTLE_MSG = "admin.battle";
    public final static String DELETE_MSG = "admin.delete";
    public final static String WHICH_TO_DELETE_MSG = "admin.deleteInput";
    public final static String DELETED_SUCCESSFULLY_MSG = "admin.deleted";
    public final static String WHICH_TO_CHANGE_MSG = "admin.changeInput";
    public final static String CHANGE_MSG = "admin.change";
    public final static String ADD_MSG = "admin.add";
    public final static String WHICH_TO_ADD_MSG = "admin.addInput";
    public final static String SEE_DROID_ON_BATTLEFIELD_MSG = "admin.look";
    public final static String СHOOSE_FIRST_DROID_FOR_ADDING_MSG = "admin.add1d";
    public final static String СHOOSE_SECOND_DROID_FOR_ADDING_MSG = "admin.add2d";
    public final static String INVALID_CHOICE_MSG = "user.invalid";
    public final static String WINNER_MSG = "user.winner";
    public final static String SPACE_MSG = "admin.noSpace";
    public final static String DROIDS_ON_BATTLE_MSG = "admin.droidsOnBattle";
    public final static String NO_DROIDS_MSG = "admin.no";
    public final static String NO_DROIDS_TO_DELETE_MSG = "admin.noDel";
    public final static String NO_DROIDS_TO_CHANGE_MSG = "admin.noChg";
    public final static String EXIT_MSG = "admin.exit";

    public void sendMsg(String str){
        System.out.println(str);
    }

    public void sendError(String str){
        System.err.println(str);
    }

}
