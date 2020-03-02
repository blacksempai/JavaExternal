package com.company.controller;

import com.company.model.DroidBattleField;
import com.company.droids.Droid;
import com.company.model.DroidFactory;
import com.company.model.DroidTypes;
import com.company.view.AdminMenuView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class AdminMenu {
    AdminMenuView adminMenuView;
    DroidBattleField battleField;
    DroidFactory droidFactory = new DroidFactory();
    ResourceBundle resourceBundle;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public AdminMenu() {
    }

    public AdminMenu(AdminMenuView adminMenuView, DroidBattleField battleField , ResourceBundle resourceBundle) {
        this.adminMenuView = adminMenuView;
        this.battleField = battleField;
        this.resourceBundle = resourceBundle;
    }

    public void run() {
        getMenu();
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
                        adminMenuView.sendMsg(resourceBundle.getString(adminMenuView.WHICH_TO_DELETE_MSG));
                        droidDeleted = deleteDroid(selectFromTwoDroids());
                        run();
                        break;
                    }
                    case "3": {
                        adminMenuView.sendMsg(resourceBundle.getString(adminMenuView.WHICH_TO_CHANGE_MSG));
                        changeDroid(selectFromTwoDroids());
                        run();
                        break;
                    }
                    case "4": {
                        adminMenuView.sendMsg(resourceBundle.getString(adminMenuView.WHICH_TO_ADD_MSG));
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
                        adminMenuView.sendMsg(resourceBundle.getString(adminMenuView.INVALID_CHOICE_MSG));
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
        adminMenuView.sendMsg(resourceBundle.getString(adminMenuView.DROIDS_ON_BATTLE_MSG));
        if (battleField.getDroid1() != null) {
            System.out.println(battleField.getDroid1().getDroidName());
        } else {
            adminMenuView.sendMsg(resourceBundle.getString(adminMenuView.NO_DROIDS_MSG));
        }
        if (battleField.getDroid2() != null) {
            System.out.println(battleField.getDroid2().getDroidName());
        } else {
            adminMenuView.sendMsg(resourceBundle.getString(adminMenuView.NO_DROIDS_MSG));
        }
    }

    private boolean addDroid() {
        boolean done = false;
        int droid = 0;
        while (droid == 0) {
            droid = getDroids();
            if (battleField.getDroid1() == null) {
                battleField.setDroid1(addDroidByNumber(droid));
                done = true;
            } else if (battleField.getDroid2() == null) {
                battleField.setDroid2(addDroidByNumber(droid));
                done = true;
            } else {
                System.err.println(resourceBundle.getString(adminMenuView.SPACE_MSG));
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
            adminMenuView.sendMsg(resourceBundle.getString(adminMenuView.NO_DROIDS_TO_CHANGE_MSG));
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
        adminMenuView.sendMsg(resourceBundle.getString(adminMenuView.WHICH_TO_ADD_MSG));
        addDroid();
    }

    private boolean deleteDroid(int number) {
        if (number == -1) {
            adminMenuView.sendMsg(resourceBundle.getString(adminMenuView.NO_DROIDS_TO_DELETE_MSG));
            return false;
        }
        while (number == 0) {
            number = selectFromTwoDroids();
        }

        switch (number) {
            case 1: {
                battleField.setDroid1(null);
                adminMenuView.sendMsg(resourceBundle.getString(adminMenuView.DELETED_SUCCESSFULLY_MSG));
                return true;

            }
            case 2: {
                battleField.setDroid2(null);
                adminMenuView.sendMsg(resourceBundle.getString(adminMenuView.DELETED_SUCCESSFULLY_MSG));
                return true;
            }
            default: {
                adminMenuView.sendMsg(resourceBundle.getString(adminMenuView.INVALID_CHOICE_MSG));
                return false;
            }
        }
    }

    private void makeBattle() {
        adminMenuView.sendMsg(resourceBundle.getString(adminMenuView.СHOOSE_FIRST_DROID_FOR_ADDING_MSG));
        int droid = 0;
        while (droid == 0) {
            droid = getDroids();
            battleField.setDroid1(addDroidByNumber(droid));
        }
        adminMenuView.sendMsg(resourceBundle.getString(adminMenuView.СHOOSE_SECOND_DROID_FOR_ADDING_MSG));
        droid = 0;
        while (droid == 0) {
            droid = getDroids();
            battleField.setDroid2(addDroidByNumber(droid));
        }
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
                adminMenuView.sendMsg(resourceBundle.getString(adminMenuView.INVALID_CHOICE_MSG));
                return null;
            }
        }

    }

    public int selectFromTwoDroids() {
        if (battleField.getDroid1() == null) {
            adminMenuView.sendMsg(resourceBundle.getString(adminMenuView.NO_DROIDS_MSG));
        } else {
            System.out.println(battleField.getDroid1().getDroidName() + " - 1");
        }
        if (battleField.getDroid2() == null) {
            adminMenuView.sendMsg(resourceBundle.getString(adminMenuView.NO_DROIDS_MSG));
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
                        adminMenuView.sendMsg(resourceBundle.getString(adminMenuView.NO_DROIDS_MSG));
                    } else {
                        return 1;
                    }
                }
                case "2": {
                    if (battleField.getDroid2() == null) {
                        adminMenuView.sendMsg(resourceBundle.getString(adminMenuView.NO_DROIDS_MSG));
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

    private void getMenu(){
        adminMenuView.sendMsg(resourceBundle.getString(adminMenuView.MENU_MSG));
        adminMenuView.sendMsg(resourceBundle.getString(adminMenuView.MAKE_A_BATTLE_MSG));
        adminMenuView.sendMsg(resourceBundle.getString(adminMenuView.DELETE_MSG));
        adminMenuView.sendMsg(resourceBundle.getString(adminMenuView.CHANGE_MSG));
        adminMenuView.sendMsg(resourceBundle.getString(adminMenuView.ADD_MSG));
        adminMenuView.sendMsg(resourceBundle.getString(adminMenuView.SEE_DROID_ON_BATTLEFIELD_MSG));
        adminMenuView.sendMsg(resourceBundle.getString(adminMenuView.EXIT_MSG));
    }

    private int getDroids() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        adminMenuView.sendMsg(DroidTypes.ONEPUNCH + " - 1");
        adminMenuView.sendMsg(DroidTypes.RANDOM + " - 2");
        adminMenuView.sendMsg(DroidTypes.SPEEDY + " - 3");
        adminMenuView.sendMsg(DroidTypes.SLOWPOKE + " - 4");
        adminMenuView.sendMsg(DroidTypes.TANKY + " - 5");
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
                    adminMenuView.sendError(resourceBundle.getString(adminMenuView.INVALID_CHOICE_MSG));
                    return 0;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
