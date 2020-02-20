package com.company.controller;

import com.company.model.DroidBattleField;
import com.company.view.CommonUserMenuView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class CommonUserMenu {
    CommonUserMenuView commonUserMenuView;
    DroidBattleField droidBattleField;
    boolean wrongDroid = true;
    ResourceBundle resourceBundle;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public CommonUserMenu(CommonUserMenuView commonUserMenuView, DroidBattleField dr, ResourceBundle resourceBundle) {
        this.commonUserMenuView = commonUserMenuView;
        this.droidBattleField = dr;
        this.resourceBundle = resourceBundle;
    }

    public void run() {
        boolean sessionEnded = false;
        while (!sessionEnded) {
            getMenu();
            try {
                String userInput = br.readLine();
                switch (userInput) {
                    case "1": {
                        setBet();
                        run();
                        break;
                    }
                    case "2": {
                        sessionEnded = true;
                        break;
                    }
                    default: {
                        commonUserMenuView.sendMsg(resourceBundle.getString(commonUserMenuView.INVALID_CHOICE_MSG));
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
    }

    private void getDroidsMsg() {
            commonUserMenuView.sendMsg(droidBattleField.getDroid1().getDroidName() + " - 1");
            commonUserMenuView.sendMsg(droidBattleField.getDroid2().getDroidName() + " - 2");
    }

    public void setBet() {
        commonUserMenuView.sendMsg(resourceBundle.getString(commonUserMenuView.WHO_FIGHTS_MSG));
        try {
            do {
                if (droidBattleField.hasDroids()) {
                    getDroidsMsg();
                    String userInput = br.readLine();
                    commonUserMenuView.sendMsg(droidBattleField.fight());
                    switch (userInput) {
                        case "1": {
                            commonUserMenuView.sendMsg(resourceBundle.getString(commonUserMenuView.CHOOSE_FIRST_DROID_MSG));
                            wrongDroid = false;
                            if (droidBattleField.getWinner().equals(droidBattleField.getDroid1())) {
                                commonUserMenuView.sendMsg(resourceBundle.getString(commonUserMenuView.WINNER_MSG) + droidBattleField.getDroid1().getDroidName());
                                commonUserMenuView.sendMsg(resourceBundle.getString(commonUserMenuView.VICTORY_MSG));
                            } else {
                                commonUserMenuView.sendMsg(resourceBundle.getString(commonUserMenuView.LOST_MSG));
                            }
                            break;
                        }
                        case "2": {
                            commonUserMenuView.sendMsg(resourceBundle.getString(commonUserMenuView.CHOOSE_SECOND_DROID_MSG));
                            wrongDroid = false;
                            if (droidBattleField.fight().equals(droidBattleField.getDroid2())) {
                                commonUserMenuView.sendMsg(resourceBundle.getString(commonUserMenuView.WINNER_MSG) + droidBattleField.getDroid2().getDroidName());
                                commonUserMenuView.sendMsg(resourceBundle.getString(commonUserMenuView.VICTORY_MSG));
                            } else {
                                commonUserMenuView.sendMsg(resourceBundle.getString(commonUserMenuView.LOST_MSG));
                            }
                            break;
                        }
                        default: {
                            commonUserMenuView.sendMsg(resourceBundle.getString(commonUserMenuView.WRONG_CHOOSE_MSG));
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

    private void getMenu(){
        commonUserMenuView.sendMsg(resourceBundle.getString(commonUserMenuView.MENU_MSG));
        commonUserMenuView.sendMsg(resourceBundle.getString(commonUserMenuView.SET_BET_MSG));
        commonUserMenuView.sendMsg(resourceBundle.getString(commonUserMenuView.EXIT_MSG));

    }

}
