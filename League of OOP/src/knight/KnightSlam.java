package knight;

import gameplay.*;

public class KnightSlam {
	
	Knight mySelf;
	Player myEnemy;
	public KnightSlam ( Knight mySelf, Player myEnemy ) {
		this.mySelf = mySelf;
		this.myEnemy = myEnemy;
	}
	
	Modifier modify;
	
	public float DamageDeal () {
		modify = new Modifier (-20, 20, -10, 5, myEnemy.hero);
		return (100 + 40 * mySelf.level) * (100 + modify.Modify()) / 100;
	}
	
	public Overtime getOvertime () {
		myEnemy.overtime = new Overtime(0, 0, "noEffect", 0, new Damage(0));
		myEnemy.overtime.SlamMovementIncapacity = "triggered";
		return myEnemy.overtime;
	}
	
	public int DamageDealWithoutRaceModifier () {
		return 100 + 40 * mySelf.level;
	}
	
}
