package com.company.view;

import com.company.view.AutorizationView;

public class InvalidUsernameException extends Exception {
    @Override
    public String getMessage() {
        return AutorizationView.INVALID_USERNAME_MSG;
    }
}
