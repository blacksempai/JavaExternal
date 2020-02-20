package com.company.view;

import com.company.model.DroidBattleField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommonUserMenu {
    CommonUserMenuView commonUserMenuView;
    DroidBattleField droidBattleField;
    boolean wrongDroid = true;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public CommonUserMenu(CommonUserMenuView commonUserMenuView, DroidBattleField dr) {
        this.commonUserMenuView = commonUserMenuView;
        this.droidBattleField = dr;
    }

    public void run() {
        boolean sessionEnded = false;
        while (!sessionEnded) {
            commonUserMenuView.getMenu();
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
                        commonUserMenuView.sendMsg(commonUserMenuView.INVALID_CHOICE_MSG);
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
        commonUserMenuView.sendMsg(commonUserMenuView.WHO_FIGHTS_MSG);
        try {
            do {
                if (droidBattleField.hasDroids()) {
                    getDroidsMsg();
                    String userInput = br.readLine();
                    switch (userInput) {
                        case "1": {
                            commonUserMenuView.sendMsg(commonUserMenuView.CHOOSE_FIRST_DROID_MSG);
                            wrongDroid = false;
                            if (droidBattleField.getWinner().equals(droidBattleField.getDroid1())) {
                                commonUserMenuView.sendMsg(commonUserMenuView.WINNER_MSG + droidBattleField.getDroid1().getDroidName());
                                commonUserMenuView.sendMsg(commonUserMenuView.VICTORY_MSG);
                            } else {
                                commonUserMenuView.sendMsg(commonUserMenuView.LOST_MSG);
                            }
                            break;
                        }
                        case "2": {
                            commonUserMenuView.sendMsg(commonUserMenuView.CHOOSE_SECOND_DROID_MSG);
                            wrongDroid = false;
                            if (droidBattleField.fight().equals(droidBattleField.getDroid2())) {
                                commonUserMenuView.sendMsg(commonUserMenuView.WINNER_MSG + droidBattleField.getDroid2().getDroidName());
                                commonUserMenuView.sendMsg(commonUserMenuView.VICTORY_MSG);
                            } else {
                                commonUserMenuView.sendMsg(commonUserMenuView.LOST_MSG);
                            }
                            break;
                        }
                        default: {
                            commonUserMenuView.sendMsg(commonUserMenuView.WRONG_CHOOSE_MSG);
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
