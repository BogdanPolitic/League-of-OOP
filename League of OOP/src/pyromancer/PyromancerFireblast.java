package pyromancer;

import gameplay.*;

public class PyromancerFireblast {
	Pyromancer mySelf;
	Player myEnemy;
	
	public PyromancerFireblast(Pyromancer mySelf, Player myEnemy) {
		this.mySelf = mySelf;
		this.myEnemy = myEnemy;
	}
	
	Modifier modify;
	
	public float DamageDeal () {
		modify = new Modifier (-20, 20, -10, 5, myEnemy.hero);
		return (350 + 50 * mySelf.level) * (100 + modify.Modify()) / 100;
	}
	
	public float DamageDealWithoutRaceModifier () {
		return (350 + 50 * mySelf.level);
	}
	
}
