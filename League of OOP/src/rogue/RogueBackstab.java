package rogue;

import gameplay.*;

public class RogueBackstab {
	
	Rogue mySelf;
	Player myEnemy;
	
	public RogueBackstab(Rogue mySelf, Player myEnemy) {
		this.mySelf = mySelf;
		this.myEnemy = myEnemy;
	}
	
	Modifier modify;
	
	public float DamageDeal () {;
		modify = new Modifier ( 20, -10, 25, 25, myEnemy.hero );
		float dmg = ( 200 + 20 * mySelf.level ) * ( 100 + modify.Modify() ) / 100;
		
		if ( mySelf.numberOfAttacks % 3 == 2 ) {
			dmg *= 1.5;
		}
		
		return dmg;
	}
	
	public float DamageDealWithoutRaceModifier () {;
		float dmg = 200 + 20 * mySelf.level;
		
		if ( myEnemy.numberOfAttacks % 3 == 2 ) {
			dmg *= 1.5;
		}
		
		return dmg;
	}
	
}
