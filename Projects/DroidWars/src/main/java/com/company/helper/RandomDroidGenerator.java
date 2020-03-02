package com.company.helper;

import com.company.droids.Droid;
import com.company.model.DroidFactory;
import com.company.model.DroidTypes;

import java.util.Random;

public class RandomDroidGenerator {
    Random random = new Random();
    DroidFactory droidFactory = new DroidFactory();

    public Droid nextDroid(){
        switch (random.nextInt(5)){
            case 0:{
                return droidFactory.getDroid(DroidTypes.SLOWPOKE);
            }
            case 1:{
                return droidFactory.getDroid(DroidTypes.RANDOM);
            }
            case 2:{
                return droidFactory.getDroid(DroidTypes.SPEEDY);
            }
            case 3:{
                return droidFactory.getDroid(DroidTypes.TANKY);
            }
            case 4:{
                return droidFactory.getDroid(DroidTypes.ONEPUNCH);
            }
            default:{
                return new Droid();
            }
        }

    }
}
