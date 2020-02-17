package com.company;

import com.company.model.User;
import com.company.view.Autorization;
import com.company.view.AutorizationView;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        AutorizationView autorizationView = new AutorizationView();
        Autorization autorization = new Autorization(user, autorizationView);
        autorization.autorize();
    }
}
