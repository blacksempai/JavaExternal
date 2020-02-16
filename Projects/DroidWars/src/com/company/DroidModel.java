/** @author: Andriy Moskalenko */
package com.company;

import java.util.HashMap;
import java.util.Map;

public class DroidModel {
    private DroidFactory factory;
    private Battle battle;
    private Map<String,User> users;

    public DroidModel() {
        this.factory = new DroidFactory();
        this.battle = new Battle();
        this.users = new HashMap<String,User>();
        //TODO: make a file with logins and passwords
        User admin = new User("root", "root", UserType.ADMIN);
        User user = new User("user", "user", UserType.USER);
        users.put(admin.getLogin(),admin);
        users.put(user.getLogin(),user);
    }

    public DroidModel(DroidFactory factory, Battle battle) {
        this.factory = factory;
        this.battle = battle;
    }

    public DroidFactory getFactory() {
        return factory;
    }

    public void setFactory(DroidFactory factory) {
        this.factory = factory;
    }

    public Battle getBattle() {
        return battle;
    }

    public void setBattle(Battle battle) {
        this.battle = battle;
    }

    public boolean preformBattle(DroidTypes a, DroidTypes b){
        return battle.warOfTwoDroids(factory.getDroid(a), factory.getDroid(b));
    }

    public Droid getDroid(DroidTypes droidType){
        return factory.getDroid(droidType);
    }

    public boolean authentication(String[] loginAndPassword){
        String login = loginAndPassword[0];
        String password = loginAndPassword[1];
        if (!users.containsKey(login)) return false;
        return users.get(login).getPassword().equals(password);
    }

    public boolean registration(String[] loginAndPassword){
        String login = loginAndPassword[0];
        String password = loginAndPassword[1];
        if (!users.containsKey(login)){
            users.put(login, new User(login, password, UserType.USER));
            return true;
        }
        return false;
    }
}
