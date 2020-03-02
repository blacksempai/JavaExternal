package com.company.model;

public class Model {
    User user;
    DroidBattleField droidBattleField;

    public Model() {
        this.user = new User();
        this.droidBattleField = new DroidBattleField();
    }

    public Model(User user, DroidBattleField droidBattleField) {
        this.user = user;
        this.droidBattleField = droidBattleField;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public DroidBattleField getDroidBattleField() {
        return droidBattleField;
    }

    public void setDroidBattleField(DroidBattleField droidBattleField) {
        this.droidBattleField = droidBattleField;
    }
}
