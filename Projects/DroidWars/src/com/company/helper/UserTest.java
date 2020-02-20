package com.company.helper;

import com.company.model.User;
import com.company.view.InvalidUsernameException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void addUser_ExistingUser_InvalidUsernameExceptionThrown() {
        User jUser = new User();
        jUser.setUserName("admin");
        Assertions.assertThrows(InvalidUsernameException.class, () -> {
            jUser.addUser();
        });
    }
}