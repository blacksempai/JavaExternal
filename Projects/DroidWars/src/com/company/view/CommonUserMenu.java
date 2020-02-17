package com.company.view;

import com.company.model.DroidBattleField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommonUserMenu {
    CommonUserMenuView commonUserMenuView;
    DroidBattleField dr;
    boolean wrongDroid = true;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public CommonUserMenu(CommonUserMenuView commonUserMenuView, DroidBattleField dr) {
        this.commonUserMenuView = commonUserMenuView;
        this.dr = dr;
    }

    public void run() {
        boolean exit = true;
        while (exit) {
            commonUserMenuView.getMenu();
            try {
                String choice = br.readLine();
                switch (choice) {
                    case "1": {
                        setBet();
                        run();
                        break;
                    }
                    case "2": {
                        exit = false;
                        break;
                    }
                    default: {
                        commonUserMenuView.getMsg(commonUserMenuView.INVALID_CHOICE_MSG);
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
    }

    public void whoFights() {
        System.out.println(commonUserMenuView.WHO_FIGHTS_MSG);

    }

    public boolean getDroidsMsg() {
        if (dr.getDroid1() == null || dr.getDroid2() == null) {
            System.out.println(commonUserMenuView.NO_DROIDS_MSG);
            return false;
        } else {
            System.out.println(dr.getDroid1().getDroidName() + " - 1");
            System.out.println(dr.getDroid2().getDroidName() + " - 2");
            return true;
        }
    }

    public void setBet() {
        whoFights();
        try {
            do {
                if (getDroidsMsg()) {
                    String choice = br.readLine();
                    switch (choice) {
                        case "1": {
                            commonUserMenuView.getMsg(commonUserMenuView.CHOOSE_FIRST_DROID_MSG);
                            wrongDroid = false;
                            if (dr.fight().equals(dr.getDroid1())) {
                                System.out.println(commonUserMenuView.WINNER_MSG + dr.getDroid1().getDroidName());
                                commonUserMenuView.getMsg(commonUserMenuView.VICTORY_MSG);
                            } else {
                                commonUserMenuView.getMsg(commonUserMenuView.LOST_MSG);
                            }
                            break;
                        }
                        case "2": {
                            commonUserMenuView.getMsg(commonUserMenuView.CHOOSE_SECOND_DROID_MSG);
                            wrongDroid = false;
                            if (dr.fight().equals(dr.getDroid2())) {
                                System.out.println(commonUserMenuView.WINNER_MSG + dr.getDroid2().getDroidName());
                                commonUserMenuView.getMsg(commonUserMenuView.VICTORY_MSG);
                            } else {
                                commonUserMenuView.getMsg(commonUserMenuView.LOST_MSG);
                            }
                            break;
                        }
                        default: {
                            commonUserMenuView.getMsg(commonUserMenuView.WRONG_CHOOSE_MSG);
                        }
                    }
                } else {
                    return;
                }
            } while (wrongDroid);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
