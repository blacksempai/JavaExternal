/** @author: Andriy Moskalenko */
package com.company.strategy;

import com.company.droids.Droid;

import java.io.Serializable;

public class NoSuperPower implements SuperPower, Serializable {
    @Override
    public void useSuperPower(Droid thisDroid, Droid enemy) {

    }
}
