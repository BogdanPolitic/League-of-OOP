package pyromancer;

import gameplay.*;

public class PyromancerIgnite {
	Pyromancer mySelf;
	Player myEnemy;
	
	public PyromancerIgnite (Pyromancer mySelf, Player myEnemy) {
		this.mySelf = mySelf;
		this.myEnemy = myEnemy;
	}
	
	Modifier modify;
	
	public float DamageDeal () {
		modify = new Modifier (-20, 20, -10, 5, myEnemy.hero);
		return (150 + 20 * mySelf.level) * (100 + modify.Modify()) / 100;
	}
	
	public Overtime getOvertime () {
		modify = new Modifier (-20, 20, -10, 5, myEnemy.hero);
		myEnemy.overtime = new Overtime(0, 0, "noEffect", 0, new Damage(0));
		myEnemy.overtime.IgniteOvertimeDamage = Math.round(( 50 + 30 * mySelf.level ) * ( 100 + modify.Modify() ) / 100 * this.terrainAmplifierForPyromancer(mySelf.environment));
		myEnemy.overtime.IgniteOvertimeRounds = 2;
		
		return myEnemy.overtime;
	}
	
	public float DamageDealWithoutRaceModifier () {
		myEnemy.overtime = new Overtime(0, 0, "noEffect", 0, new Damage(0));
		myEnemy.overtime.IgniteOvertimeDamage = 50 + 30 * mySelf.level;
		myEnemy.overtime.IgniteOvertimeRounds = 2;
		
		return 150 + 20 * mySelf.level;
	}
	
	public float terrainAmplifierForPyromancer ( char envi ) {
		if ( envi == 'V' ) {
			return (float)1.25;
		}
		return 1;
	}
	
}
