/** @author: Andriy Moskalenko */
package com.company;

public class DroidFactory {
    Droid droid = null;

    public Droid getDroid(DroidTypes type) {
        //Тут створюються дроїди. Додайте свого та пропишіть свої характеристики в конструктор.
        switch (type) {
            case SLOWPOKE:
                droid = new Droid(20,10,70,"slowpoke");
                break;
            case SPEEDY:
                droid = new SpeedyDroid();
                break;
            case ONEPUNCH:
                droid = new OnePunchDroid();
                break;
            case RANDOM:
                droid = new RandomDroid();
                break;
            case TANKY :
                droid = new TankyDroid();
                break;
            default:
                throw new IllegalArgumentException("Wrong Droid type:" + type);
        }
        return droid;
    }
}
