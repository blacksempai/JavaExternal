package com.company;

import com.company.model.User;
import com.company.view.Controller;
import com.company.view.AutorizationView;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        AutorizationView authorizationView = new AutorizationView();
        Controller controller = new Controller(user, authorizationView);
        controller.session();
    }
}
