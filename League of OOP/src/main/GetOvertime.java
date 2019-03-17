package main;

import gameplay.*;
import pyromancer.*;
import knight.*;
import rogue.*;

public class GetOvertime {
	
	Player mySelf, myEnemy;
	
	
	
	public GetOvertime(Player mySelf, Player myEnemy) {
		this.mySelf = mySelf;
		this.myEnemy = myEnemy;
	}

	public Overtime getOvertime () {
		switch ( myEnemy.hero ) {
			case "Pyromancer" :
				return ( new PyromancerIgnite ((Pyromancer)myEnemy, mySelf)).getOvertime();
			case "Knight" :
				return ( new KnightSlam ((Knight)myEnemy, mySelf)).getOvertime();
			case "Rogue" :
				return ( new RogueParalysis ((Rogue)myEnemy, mySelf)).getOvertime();
			default :
				return mySelf.overtime;
		}
	}
	
}
