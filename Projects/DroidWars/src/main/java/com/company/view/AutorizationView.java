package com.company.view;

public class AutorizationView {
    public static final String GREETINGS_MSG = "auth.greetings";
    public static final String LOGIN_MSG = "auth.login";
    public static final String CREATE_USER_MSG = "auth.create";
    public static final String INPUT_USERNAME_MSG = "auth.user";
    public static final String INPUT_PASSWORD__MSG = "auth.pass";
    public static final String INPUT_ROLE__MSG = "auth.role";
    public static final String INVALID_MSG = "auth.invalid";
    public static final String INVALID_USERNAME_MSG = "auth.invalidUser";
    public static final String INVALID_ROLE_MSG = "auth.invalidRole";
    public static final String NO_SUCH_ACCOUNT_MSG = "auth.noAcc";
    public static final String VALID_USERNAME_REQUIREMENTS_MSG = "auth.logRegEx";
    public static final String VALID_PASSWORD_REQUIREMENTS_MSG = "auth.passRegEx";
    public static final String REGISTRATION_MSG = "auth.regS";
    public static final String REGISTRATION_FAILED_MSG = "auth.regF";
    public static final String EXIT_MSG = "auth.exit";
    public static final String USER_EXIST_MSG = "auth.userExist";


    public void sendMsg(String str) {
        System.out.println(str);
    }

    public String getMsg(String str) {
        return str;
    }

    public void sendError(String str) {
        System.err.println(str);
    }

}
