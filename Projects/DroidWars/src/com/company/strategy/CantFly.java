/** @author: Andriy Moskalenko */
package com.company.strategy;

import com.company.droids.Droid;
import com.company.strategy.Flyable;

import java.io.Serializable;

public class CantFly implements Flyable, Serializable {
    @Override
    public void fly(Droid thisDroid) {

    }
}
