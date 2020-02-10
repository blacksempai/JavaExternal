package com.company;

public class Main {

    public static void main(String[] args) {
	Droid dr1 = new Droid("slowpoke");
	dr1.displayInfo();
	Droid dr2 = new Droid("speedy");
	dr2.displayInfo();
	Battle battle = new Battle();
	battle.warOfTwoDroids(dr1,dr2);

    }
}
