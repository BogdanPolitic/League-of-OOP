package knight;

import gameplay.*;
import pyromancer.*;
import wizard.*;
import rogue.*;

public class KnightExecute {
	
	Knight mySelf;
	Player myEnemy;
	public KnightExecute(Knight mySelf, Player myEnemy) {
		this.mySelf = mySelf;
		this.myEnemy = myEnemy;
	}
	
	Modifier modify;
	
	public float DamageDeal () {
		modify = new Modifier (15, 0, 10, -20, myEnemy.hero);
		switch ( myEnemy.hero ) {
			case "Pyromancer" :
				if ( ((Pyromancer)myEnemy).hp.CurrentHP < Math.min((0.2 + 0.01 * myEnemy.level) * ((Pyromancer)myEnemy).hp.BasicHP, 0.4 * ((Pyromancer)myEnemy).hp.BasicHP) ) {
					return (float)((Pyromancer)myEnemy).hp.CurrentHP;
				}
				break;
			case "Knight" :
				if ( ((Knight)myEnemy).hp.CurrentHP < Math.min((0.2 + 0.01 * myEnemy.level) * ((Knight)myEnemy).hp.BasicHP, 0.4 * ((Knight)myEnemy).hp.BasicHP) ) {
					return (float)((Knight)myEnemy).hp.CurrentHP;
				}
				break;
			case "Wizard" :
				if ( ((Wizard)myEnemy).hp.CurrentHP < Math.min((0.2 + 0.01 * myEnemy.level) * ((Wizard)myEnemy).hp.BasicHP, 0.4 * ((Wizard)myEnemy).hp.BasicHP) ) {
					return (float)((Wizard)myEnemy).hp.CurrentHP;
				}
				break;
			default :
				if ( ((Rogue)myEnemy).hp.CurrentHP < Math.min((0.2 + 0.01 * myEnemy.level) * ((Rogue)myEnemy).hp.BasicHP, 0.4 * ((Rogue)myEnemy).hp.BasicHP) ) {
					return (float)((Rogue)myEnemy).hp.CurrentHP;
				}
				break;
		}
		return (float)( (200 + 30 * mySelf.level) * (100 + modify.Modify()) / 100 );
	}
	
	public float DamageDealWithoutRaceModifier () {
		switch ( myEnemy.hero ) {
			case "Pyromancer" :
				if ( ((Pyromancer)myEnemy).hp.CurrentHP < Math.min((0.2 + 0.01 * myEnemy.level) * ((Pyromancer)myEnemy).hp.BasicHP, 0.4 * ((Pyromancer)myEnemy).hp.BasicHP) ) {
					return (float)((Pyromancer)myEnemy).hp.CurrentHP;
				}
				break;
			case "Knight" :
				if ( ((Knight)myEnemy).hp.CurrentHP < Math.min((0.2 + 0.01 * myEnemy.level) * ((Knight)myEnemy).hp.BasicHP, 0.4 * ((Knight)myEnemy).hp.BasicHP) ) {
					return (float)((Knight)myEnemy).hp.CurrentHP;
				}
				break;
			case "Wizard" :
				if ( ((Wizard)myEnemy).hp.CurrentHP < Math.min((0.2 + 0.01 * myEnemy.level) * ((Wizard)myEnemy).hp.BasicHP, 0.4 * ((Wizard)myEnemy).hp.BasicHP) ) {
					return (float)((Wizard)myEnemy).hp.CurrentHP;
				}
				break;
			default :
				if ( ((Rogue)myEnemy).hp.CurrentHP < Math.min((0.2 + 0.01 * myEnemy.level) * ((Rogue)myEnemy).hp.BasicHP, 0.4 * ((Rogue)myEnemy).hp.BasicHP) ) {
					return (float)((Rogue)myEnemy).hp.CurrentHP;
				}
				break;
		}
		return 200 + 30 * mySelf.level;
	}
	
}
