package com.company.view;

import com.company.model.DroidBattleField;
import com.company.droids.Droid;
import com.company.model.DroidFactory;
import com.company.model.DroidTypes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AdminMenu {
    AdminMenuView adminMenuView;
    DroidBattleField battleField;
    DroidFactory droidFactory = new DroidFactory();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public AdminMenu() {
    }

    public AdminMenu(AdminMenuView adminMenuView, DroidBattleField battleField) {
        this.adminMenuView = adminMenuView;
        this.battleField = battleField;
    }

    public void run() {
        adminMenuView.getMenu();
        boolean exit = true;
        boolean droidDeleted = true;
        boolean droidAdded = true;
        while (exit) {
            try {
                String choice = br.readLine();
                switch (choice) {
                    case "1": {
                        makeBattle();
                        run();
                        break;
                    }
                    case "2": {
                        adminMenuView.sendMsg(adminMenuView.WHICH_TO_DELETE_MSG);
                        droidDeleted = deleteDroid(selectFromTwoDroids());
                        run();
                        break;
                    }
                    case "3": {
                        adminMenuView.sendMsg(adminMenuView.WHICH_TO_CHANGE_MSG);
                        changeDroid(selectFromTwoDroids());
                        run();
                        break;
                    }
                    case "4": {
                        adminMenuView.sendMsg(adminMenuView.WHICH_TO_ADD_MSG);
                        droidAdded = addDroid();
                        run();
                        break;
                    }
                    case "5": {
                        lookOnTheBattlefield();
                        run();
                        break;
                    }
                    case "6": {
                        exit = false;
                        return;
                    }
                    default: {
                        adminMenuView.sendMsg(adminMenuView.INVALID_CHOICE_MSG);
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
    }

    private void lookOnTheBattlefield() {
        adminMenuView.sendMsg(adminMenuView.DROIDS_ON_BATTLE_MSG);
        if (battleField.getDroid1() != null) {
            System.out.println(battleField.getDroid1().getDroidName());
        } else {
            adminMenuView.sendMsg(adminMenuView.NO_DROIDS_MSG);
        }
        if (battleField.getDroid2() != null) {
            System.out.println(battleField.getDroid2().getDroidName());
        } else {
            adminMenuView.sendMsg(adminMenuView.NO_DROIDS_MSG);
        }
    }

    private boolean addDroid() {
        boolean done = false;
        int droid = 0;
        while (droid == 0) {
            droid = adminMenuView.getDroids();
            if (battleField.getDroid1() == null) {
                battleField.setDroid1(addDroidByNumber(droid));
                done = true;
            } else if (battleField.getDroid2() == null) {
                battleField.setDroid2(addDroidByNumber(droid));
                done = true;
            } else {
                System.err.println(adminMenuView.SPACE_MSG);
                break;
            }
        }
        lookOnTheBattlefield();
        return done;
    }

    private void changeDroid(int number) {
        while (number == 0) {
            number = selectFromTwoDroids();
        }
        if (number == -1) {
            adminMenuView.sendMsg(adminMenuView.NO_DROIDS_TO_CHANGE_MSG);
            return;
        }
        switch (number) {
            case 1: {
                deleteDroid(1);
                break;
            }
            case 2: {
                deleteDroid(2);
                break;
            }
            default:
                break;

        }
        adminMenuView.sendMsg(adminMenuView.WHICH_TO_ADD_MSG);
        addDroid();
    }

    private boolean deleteDroid(int number) {
        if (number == -1) {
            adminMenuView.sendMsg(adminMenuView.NO_DROIDS_TO_DELETE_MSG);
            return false;
        }
        while (number == 0) {
            number = selectFromTwoDroids();
        }

        switch (number) {
            case 1: {
                battleField.setDroid1(null);
                adminMenuView.sendMsg(adminMenuView.DELETED_SUCCESSFULLY_MSG);
                return true;

            }
            case 2: {
                battleField.setDroid2(null);
                adminMenuView.sendMsg(adminMenuView.DELETED_SUCCESSFULLY_MSG);
                return true;
            }
            default: {
                adminMenuView.sendMsg(adminMenuView.INVALID_CHOICE_MSG);
                return false;
            }
        }
    }

    private void makeBattle() {
        adminMenuView.sendMsg(adminMenuView.СHOOSE_FIRST_DROID_FOR_ADDING_MSG);
        int droid = 0;
        while (droid == 0) {
            droid = adminMenuView.getDroids();
            battleField.setDroid1(addDroidByNumber(droid));
        }
        adminMenuView.sendMsg(adminMenuView.СHOOSE_SECOND_DROID_FOR_ADDING_MSG);
        droid = 0;
        while (droid == 0) {
            droid = adminMenuView.getDroids();
            battleField.setDroid2(addDroidByNumber(droid));
        }
        adminMenuView.sendMsg(battleField.fight());
        adminMenuView.sendMsg(adminMenuView.WINNER_MSG + battleField.getWinner().getDroidName());
    }

    private Droid addDroidByNumber(int numb) {
        switch (numb) {
            case 1: {
                return droidFactory.getDroid(DroidTypes.ONEPUNCH);
            }
            case 2: {
                return droidFactory.getDroid(DroidTypes.RANDOM);
            }
            case 3: {
                return droidFactory.getDroid(DroidTypes.SPEEDY);
            }
            case 4: {
                return droidFactory.getDroid(DroidTypes.SLOWPOKE);
            }
            case 5: {
                return droidFactory.getDroid(DroidTypes.TANKY);
            }
            default: {
                adminMenuView.sendMsg(adminMenuView.INVALID_CHOICE_MSG);
                return null;
            }
        }

    }

    public int selectFromTwoDroids() {
        if (battleField.getDroid1() == null) {
            adminMenuView.sendMsg(adminMenuView.NO_DROIDS_MSG);
        } else {
            System.out.println(battleField.getDroid1().getDroidName() + " - 1");
        }
        if (battleField.getDroid2() == null) {
            adminMenuView.sendMsg(adminMenuView.NO_DROIDS_MSG);
        } else {
            System.out.println(battleField.getDroid2().getDroidName() + " - 2");
        }
        if (battleField.getDroid1() == null && battleField.getDroid2() == null) {
            return -1;
        }
        try {
            String choice = br.readLine();
            switch (choice) {
                case "1": {
                    if (battleField.getDroid1() == null) {
                        adminMenuView.sendMsg(adminMenuView.NO_DROIDS_MSG);
                    } else {
                        return 1;
                    }
                }
                case "2": {
                    if (battleField.getDroid2() == null) {
                        adminMenuView.sendMsg(adminMenuView.NO_DROIDS_MSG);
                    } else {
                        return 2;
                    }
                }
                default: {
                    return 0;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
