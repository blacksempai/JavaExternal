package com.company;

public class Main {
    public static void main(String[] args) {
        DroidFactory factory = new DroidFactory();
        Battle battle = new Battle();

        //Згоден можна було простіше реалізувати 😅;
        battle.warOfTwoDroids(factory.getDroid(DroidTypes.ONEPUNCH),factory.getDroid(DroidTypes.SLOWPOKE));
        battle.warOfTwoDroids(factory.getDroid(DroidTypes.RANDOM),factory.getDroid(DroidTypes.SPEEDY));
        battle.warOfTwoDroids(factory.getDroid(DroidTypes.SLOWPOKE),factory.getDroid(DroidTypes.RANDOM));
        battle.warOfTwoDroids(factory.getDroid(DroidTypes.SPEEDY),factory.getDroid(DroidTypes.ONEPUNCH));
        Droid a = factory.getDroid(DroidTypes.SPEEDY);
        OnePunchDroid b = (OnePunchDroid) factory.getDroid(DroidTypes.ONEPUNCH);
        b.speedSteal(a);
        battle.warOfTwoDroids(factory.getDroid(DroidTypes.TANKY),factory.getDroid(DroidTypes.ONEPUNCH));

        //Revenge!!!
        battle.warOfTwoDroids(a,b);
        //Давайте домовимося для чесної гри і епічності код тільки ДОПИСУВАТИ, а не переписувати;
        battle.warOfTwoDroids(factory.getDroid(DroidTypes.SPEEDY),factory.getDroid(DroidTypes.ONEPUNCH));

    }
}
