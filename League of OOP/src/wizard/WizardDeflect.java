package wizard;

import gameplay.*;

public class WizardDeflect {
	
	Wizard mySelf;
	Player myEnemy;
	int damageDealtByEnemy;
	
	public WizardDeflect(Wizard mySelf, Player myEnemy, int damageDealtByEnemy) {
		this.mySelf = mySelf;
		this.myEnemy = myEnemy;
		this.damageDealtByEnemy = damageDealtByEnemy;
	}
	
	Modifier modify;
	
	public float DamageDeal () {
		modify = new Modifier ( 20, 40, 30, -100, myEnemy.hero );
		return (float)(Math.min(0.35 + 0.02 * mySelf.level, 0.7) * damageDealtByEnemy) * ( 100 + modify.Modify() ) / 100;
	}
	
}
