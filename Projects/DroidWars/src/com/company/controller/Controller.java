package com.company.controller;

import com.company.model.DroidBattleField;
import com.company.model.Model;
import com.company.model.User;
import com.company.model.Role;
import com.company.view.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.ResourceBundle;

public class Controller {
    private User user;
    private AutorizationView authorizationView;
    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private DroidBattleField battleField;
    private Locale lang;
    private ResourceBundle resourceBundle;

    public Controller(Model model, AutorizationView authorizationView) {
        this.user = model.getUser();
        this.battleField = model.getDroidBattleField();
        this.authorizationView = authorizationView;
    }

    public void session() {
        boolean sessionEnded = false;
        String userInput;
        try {
            langSet();
            do {
                authorizationView.sendMsg(resourceBundle.getString(authorizationView.GREETINGS_MSG));
                    userInput = input.readLine();
                    switch (userInput) {
                        case "1": {
                            registerUser();
                            authorizationView.sendMsg(resourceBundle.getString(authorizationView.REGISTRATION_MSG));
                            break;
                        }
                        case "2": {
                            login();
                            if (user.getRole().equals(Role.ADMINISTRATOR)){
                                AdminMenuView adminMenuView = new AdminMenuView();
                                AdminMenu adminMenu = new AdminMenu(adminMenuView, battleField, resourceBundle);
                                adminMenu.run();
                                authorizationView.sendMsg(resourceBundle.getString(authorizationView.EXIT_MSG));
                                session();
                            } else if (user.getRole().equals(Role.COMMON_USER)){
                                CommonUserMenuView commonUserMenuView = new CommonUserMenuView();
                                CommonUserMenu commonUserMenu = new CommonUserMenu(commonUserMenuView, battleField, resourceBundle);
                                commonUserMenu.run();
                                authorizationView.sendMsg(resourceBundle.getString(authorizationView.EXIT_MSG));
                                session();
                            }
                            sessionEnded = true;
                            break;
                        }
                        case "3": {
                            authorizationView.sendMsg(resourceBundle.getString(authorizationView.EXIT_MSG));
                            return;
                        }
                        default: {
                            authorizationView.sendMsg(resourceBundle.getString(authorizationView.INVALID_MSG));
                            break;
                        }

                    }
            } while (!sessionEnded);
        } catch (IOException e) {
                e.printStackTrace();
            }

    }

    private void registerUser() {
        boolean userCreated = false;
        boolean argumentCorrect = false;
        do {
            try {
                authorizationView.sendMsg(resourceBundle.getString(authorizationView.CREATE_USER_MSG));
                String loginPattern = "\\w+";
                String passwordPattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{6,}";
                String userInput;
                do {
                    authorizationView.sendMsg(resourceBundle.getString(authorizationView.INPUT_USERNAME_MSG));
                    userInput = input.readLine();
                    if(!userInput.matches(loginPattern)){
                        authorizationView.sendError(resourceBundle.getString(authorizationView.VALID_USERNAME_REQUIREMENTS_MSG));
                    }
                } while (!userInput.matches(loginPattern));
                user.setUserName(userInput);

                do {
                    authorizationView.sendMsg(resourceBundle.getString(authorizationView.INPUT_PASSWORD__MSG));
                    userInput = input.readLine();
                    if(!userInput.matches(passwordPattern)){
                        authorizationView.sendError(resourceBundle.getString(authorizationView.VALID_PASSWORD_REQUIREMENTS_MSG));
                    }
                } while (!userInput.matches(passwordPattern));
                user.setPassword(userInput);
                do {
                    authorizationView.sendMsg(resourceBundle.getString(authorizationView.INPUT_ROLE__MSG));
                    String role = input.readLine();
                    switch (role) {
                        case "1": {
                            user.setRole(Role.ADMINISTRATOR);
                            argumentCorrect = true;
                            break;
                        }
                        case "2": {
                            user.setRole(Role.COMMON_USER);
                            argumentCorrect = true;
                            break;
                        }
                        default: {
                            authorizationView.sendMsg(resourceBundle.getString(authorizationView.INPUT_ROLE__MSG));
                            break;
                        }
                    }
                    } while (!argumentCorrect);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                user.addUser();
                userCreated = true;
            } catch (InvalidUsernameException invalidUsernameException) {
                invalidUsernameException.getMessage();
                authorizationView.sendError(resourceBundle.getString(authorizationView.REGISTRATION_FAILED_MSG));
                authorizationView.sendMsg(resourceBundle.getString(authorizationView.USER_EXIST_MSG));
            }
        } while (!userCreated);
    }

    private void login() {
        boolean accountExist = true;
        do {
            try {
                authorizationView.sendMsg(resourceBundle.getString(authorizationView.LOGIN_MSG));
                authorizationView.sendMsg(resourceBundle.getString(authorizationView.INPUT_USERNAME_MSG));
                String tmp = input.readLine();
                user.setUserName(tmp);
                authorizationView.sendMsg(resourceBundle.getString(authorizationView.INPUT_PASSWORD__MSG));
                tmp = input.readLine();
                user.setPassword(tmp);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (user.deserialize()==null) {
                    accountExist = true;
                    authorizationView.sendError(resourceBundle.getString(authorizationView.NO_SUCH_ACCOUNT_MSG));
                } else {
                    user.setRole(user.deserialize());
                    accountExist = false;
                }
            } catch (IOException | ClassNotFoundException e) {
                authorizationView.sendError(resourceBundle.getString(authorizationView.NO_SUCH_ACCOUNT_MSG));
            }
        } while (accountExist);
    }

    private void langSet() throws IOException {
        authorizationView.sendMsg("Type 1 to choose Ukrainian, type anything else to choose English");
        String userInput = input.readLine();
        String country;
        String language;
        if (userInput.equals("1")) {
            country = "UA";
            language = "ua";
        } else {
            country = "EN";
            language = "en";
        }
        lang = new Locale(language,country);
        resourceBundle = ResourceBundle.getBundle("text", lang);
    }

}
