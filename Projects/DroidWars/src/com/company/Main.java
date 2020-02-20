package com.company;

import com.company.model.Model;
import com.company.controller.Controller;
import com.company.view.AutorizationView;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        AutorizationView view = new AutorizationView();
        Controller controller = new Controller(model, view);
        controller.session();
    }
}
