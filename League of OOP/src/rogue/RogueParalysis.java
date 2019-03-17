package rogue;

import gameplay.*;

public class RogueParalysis {
	
	Rogue mySelf;
	Player myEnemy;
	
	public RogueParalysis (Rogue mySelf, Player myEnemy ) {
		this.mySelf = mySelf;
		this.myEnemy = myEnemy;
	}
	
	Modifier modify;
	
	public float DamageDeal () {
		
		modify = new Modifier ( -10, -20, 20, 25, myEnemy.hero );
		return (float)( ( 40 + 10 * mySelf.level ) * ( 100 + modify.Modify() ) / 100 );
				
	}
	
	public Overtime getOvertime () {
		
		modify = new Modifier ( -10, -20, 20, 25, myEnemy.hero );
		
		int rounds;
		switch ( mySelf.environment ) {
		case 'W' :
			rounds = 6;
			break;
		default:
			rounds = 3;
			break;
		}
		
		myEnemy.overtime = new Overtime(0, 0, "noEffect", 0, new Damage(0));
		myEnemy.overtime.ParalysisOvertimeRounds = rounds;
		myEnemy.overtime.ParalysisOvertimeIncapacityAndDamage.damage = Math.round(( 40 + 10 * mySelf.level ) * ( 100 + modify.Modify() ) / 100 * this.terrainAmplifierForRogue(mySelf.environment));
		
		return myEnemy.overtime;
	}
	
	public int DamageDealWithoutRaceModifier () {
		return 40 + 10 * mySelf.level;		
	}
	
	public float terrainAmplifierForRogue ( char envi ) {
		if ( envi == 'W' ) {
			return (float)1.15;
		}
		return 1;
	}
	
}
