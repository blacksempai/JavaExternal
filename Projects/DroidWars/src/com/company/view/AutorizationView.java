package com.company.view;

public class AutorizationView {
    protected static final String GREETINGS_MSG = "HELLO! Type 1 to register, type 2 to log in or type 3 to quit and press ENTER";
    protected static final String LOGIN_MSG = "Input your Username and Password ";
    protected static final String CREATE_USER_MSG = "You want to create new user type your ";
    protected static final String INPUT_USERNAME_MSG = "Username: ";
    protected static final String INPUT_PASSWORD__MSG = "Password: ";
    protected static final String INPUT_ROLE__MSG = "Role: \n 1 - administrator, 2 - user";
    protected static final String INVALID_MSG = "Invalid choice, try again! ";
    protected static final String INVALID_USERNAME_MSG = "Invalid Username try again";
    protected static final String INVALID_ROLE_MSG = "Invalid Role try again";
    protected static final String NO_SUCH_ACCOUNT_MSG = "No such account, please try again";
    protected static final String VALID_USERNAME_REQUIREMENTS_MSG = "Username has to only containt letters or digits";
    protected static final String VALID_PASSWORD_REQUIREMENTS_MSG = "Password should be > 6 symbols and contain at least 1 number and 1 lower and uppercase latin letter";
    protected static final String REGISTRATION_MSG = "Registration successful";
    protected static final String EXIT_MSG = "You have quit. Good bye!!!";
    protected static final String USER_EXIST_MSG = "User already exists, please try another name. ";


    public void getMsg(String  str){
        System.out.println(str);
    }

}
