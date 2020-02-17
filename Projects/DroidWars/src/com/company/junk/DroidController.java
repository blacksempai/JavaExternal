/** @author: Andriy Moskalenko */
package com.company.junk;

import com.company.model.DroidConsoleView;
import com.company.model.DroidModel;
import com.company.model.DroidTypes;

public class DroidController {
    DroidModel model;
    DroidConsoleView view;

    public DroidController(DroidModel model, DroidConsoleView view) {
        this.model = model;
        this.view = view;
    }

    public void droidGame(){
       DroidTypes a = view.userInput();
       DroidTypes b = view.userInput();
       view.printResults(model.preformBattle(a,b), model.getDroid(a), model.getDroid(b));
    }
}
