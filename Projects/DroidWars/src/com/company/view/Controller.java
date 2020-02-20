package com.company.view;

import com.company.model.DroidBattleField;
import com.company.model.User;
import com.company.strategy.Role;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {
    private User user;
    private AutorizationView authorizationView;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private DroidBattleField battleField = new DroidBattleField();

    public Controller(User user, AutorizationView authorizationView) {
        this.user = user;
        this.authorizationView = authorizationView;
    }

    public void session() {
        boolean sessionEnded = false;
        do {
            authorizationView.sendMsg(authorizationView.GREETINGS_MSG);
            try {
                String chooseRole = br.readLine();
                switch (chooseRole) {
                    case "1": {
                        registerUser();
                        authorizationView.sendMsg(authorizationView.REGISTRATION_MSG);
                        break;
                    }
                    case "2": {
                        login();
                        if (user.getRole().equals(Role.ADMINISTRATOR)){
                            AdminMenuView adminMenuView = new AdminMenuView();
                            AdminMenu adminMenu = new AdminMenu(adminMenuView,battleField);
                            adminMenu.run();
                            authorizationView.sendMsg(authorizationView.EXIT_MSG);
                            session();
                        } else if (user.getRole().equals(Role.COMMON_USER)){
                            CommonUserMenuView commonUserMenuView = new CommonUserMenuView();
                            CommonUserMenu commonUserMenu = new CommonUserMenu(commonUserMenuView,battleField);
                            commonUserMenu.run();
                            authorizationView.sendMsg(authorizationView.EXIT_MSG);
                            session();
                        }
                        sessionEnded = true;
                        break;
                    }
                    case "3": {
                        authorizationView.sendMsg(authorizationView.EXIT_MSG);
                        return;
                    }
                    default: {
                        authorizationView.sendMsg(authorizationView.INVALID_MSG);
                        break;
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (!sessionEnded);
    }

    public void registerUser() {
        boolean userCreated = false;
        boolean argumentCorrect = false;
        do {
            try {
                authorizationView.sendMsg(authorizationView.CREATE_USER_MSG);
                String loginPattern = "\\w+";
                String passwordPattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{6,}";
                String userInput;
                do {
                    authorizationView.sendMsg(authorizationView.INPUT_USERNAME_MSG);
                    userInput = br.readLine();
                    if(!userInput.matches(loginPattern)){
                        authorizationView.sendError(authorizationView.VALID_USERNAME_REQUIREMENTS_MSG);
                    }
                } while (!userInput.matches(loginPattern));
                user.setUserName(userInput);

                do {
                    authorizationView.sendMsg(authorizationView.INPUT_PASSWORD__MSG);
                    userInput = br.readLine();
                    if(!userInput.matches(passwordPattern)){
                        authorizationView.sendError(authorizationView.VALID_PASSWORD_REQUIREMENTS_MSG);
                    }
                } while (!userInput.matches(passwordPattern));
                user.setPassword(userInput);
                do {
                    authorizationView.sendMsg(authorizationView.INPUT_ROLE__MSG);
                    String role = br.readLine();
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
                            authorizationView.sendMsg(authorizationView.INPUT_ROLE__MSG);
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
            } catch (InvalidUsernameEcxeption invalidUsernameEcxeption) {
                invalidUsernameEcxeption.getMessage();
                authorizationView.sendError(authorizationView.REGISTRATION_FAILED_MSG);
                authorizationView.sendMsg(authorizationView.USER_EXIST_MSG);
            }
        } while (!userCreated);
    }

    public void login() {
        boolean accountExist = true;
        do {
            try {
                authorizationView.sendMsg(authorizationView.LOGIN_MSG);
                authorizationView.sendMsg(authorizationView.INPUT_USERNAME_MSG);
                String tmp = br.readLine();
                user.setUserName(tmp);
                authorizationView.sendMsg(authorizationView.INPUT_PASSWORD__MSG);
                tmp = br.readLine();
                user.setPassword(tmp);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (user.deserialize()==null) {
                    accountExist = true;
                    authorizationView.sendError(authorizationView.NO_SUCH_ACCOUNT_MSG);
                } else {
                    user.setRole(user.deserialize());
                    accountExist = false;
                }
            } catch (IOException | ClassNotFoundException e) {
                authorizationView.sendError(authorizationView.NO_SUCH_ACCOUNT_MSG);
            }
        } while (accountExist);
    }

}
