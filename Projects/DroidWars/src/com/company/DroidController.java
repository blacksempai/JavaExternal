/** @author: Andriy Moskalenko */
package com.company;

public class DroidController {
    DroidModel model;
    DroidConsoleView view;

    public DroidController(DroidModel model, DroidConsoleView view) {
        this.model = model;
        this.view = view;
    }

    public void droidGame(){
        registration();
        authentication();
        DroidTypes a = view.userInput();
        DroidTypes b = view.userInput();
        view.printResults(model.preformBattle(a,b), model.getDroid(a), model.getDroid(b));
    }

    private void authentication(){
        view.authenticationResults(model.authentication(view.authentication()));
    }

    private void registration(){
        view.registrationResults(model.registration(view.registration()));
    }
}
