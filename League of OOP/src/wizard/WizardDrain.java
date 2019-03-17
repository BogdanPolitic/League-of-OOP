package wizard;

import gameplay.*;
import pyromancer.*;
import knight.*;
import rogue.*;

public class WizardDrain {
	
	Wizard mySelf;
	Player myEnemy;
	
	public WizardDrain(Wizard mySelf, Player myEnemy) {
		this.mySelf = mySelf;
		this.myEnemy = myEnemy;
	}
	
	Modifier modify;
	
	public float DamageDeal () {
		modify = new Modifier (-20, 20, -10, 5, myEnemy.hero);
		switch ( myEnemy.hero ) {
			case "Pyromancer" :
				return (float)((0.2 + 0.05 * mySelf.level) * Math.min(0.3 * ((Pyromancer)myEnemy).hp.BasicHP, ((Pyromancer)myEnemy).hp.CurrentHP)) * (100 + modify.Modify()) / 100;
			case "Knight" :
				return (float)((0.2 + 0.05 * mySelf.level) * Math.min(0.3 * ((Knight)myEnemy).hp.BasicHP, ((Knight)myEnemy).hp.CurrentHP)) * (100 + modify.Modify()) / 100;
			case "Wizard" :
				return (float)((0.2 + 0.05 * mySelf.level) * Math.min(0.3 * ((Wizard)myEnemy).hp.BasicHP, ((Wizard)myEnemy).hp.CurrentHP)) * (100 + modify.Modify()) / 100;
			default :
				return (float)((0.2 + 0.05 * mySelf.level) * Math.min(0.3 * ((Rogue)myEnemy).hp.BasicHP, ((Rogue)myEnemy).hp.CurrentHP)) * (100 + modify.Modify()) / 100;
		}
	}
	
}
