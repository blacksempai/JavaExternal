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
                droid = new Droid(15,70,15,"speedy");
                break;
            case ONEPUNCH:
                droid = new OnePunchDroid(49,49,1, "OnePunchDroid");
                break;
            case RANDOM:
                droid = new RandomDroid(33,34,33, "RandomDroid");
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
