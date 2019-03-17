package gameplay;

import pyromancer.*;
import knight.*;
import wizard.*;
import rogue.*;

public class CalculateDamage {
	Player mySelf;
	Player myEnemy;
	int damageDealtByEnemy = 0;
	
	public CalculateDamage(Player mySelf, Player myEnemy) {
		this.mySelf = mySelf;
		this.myEnemy = myEnemy;
	}
	
	public CalculateDamage(Player mySelf, Player myEnemy, int damageDealtByEnemy) {
		this.mySelf = mySelf;
		this.myEnemy = myEnemy;
		this.damageDealtByEnemy = damageDealtByEnemy;
	}
	
	public int calculate () {
		switch ( mySelf.hero ) {
			case ( "Pyromancer" ) : { 
				return Math.round(( (new PyromancerFireblast( (Pyromancer)mySelf, myEnemy )).DamageDeal() + (new PyromancerIgnite( (Pyromancer)mySelf, myEnemy )).DamageDeal() ) * terrainAmplifierForPyromancer ( ((Pyromancer)mySelf).environment ) );
			}
			case ( "Knight" ) : { 
				return Math.round(( ( new KnightExecute( (Knight)mySelf, myEnemy )).DamageDeal() + (new KnightSlam( (Knight)mySelf, myEnemy )).DamageDeal() ) * terrainAmplifierForKnight ( ((Knight)mySelf).environment ) );
			}
			case ( "Wizard" ) : { 
				return Math.round(( ( new WizardDrain( (Wizard)mySelf, myEnemy )).DamageDeal() + (new WizardDeflect( (Wizard)mySelf, myEnemy, damageDealtByEnemy )).DamageDeal() ) * terrainAmplifierForWizard ( ((Wizard)mySelf).environment ) );
			}
			case ( "Rogue" ) : {
				return Math.round(( ( new RogueBackstab( (Rogue)mySelf, myEnemy )).DamageDeal() + (new RogueParalysis( (Rogue)mySelf, myEnemy )).DamageDeal() ) * terrainAmplifierForRogue ( ((Rogue)mySelf).environment ) );
			}
			default:
				return 0;
		}
	}
	
	public int calculateWithoutRaceModifier () {
		switch ( mySelf.hero ) {
			case ( "Pyromancer" ) : {
				return Math.round(( (new PyromancerFireblast( (Pyromancer)mySelf, myEnemy )).DamageDealWithoutRaceModifier() + (new PyromancerIgnite( (Pyromancer)mySelf, myEnemy )).DamageDealWithoutRaceModifier() ) * terrainAmplifierForPyromancer ( ((Pyromancer)mySelf).environment ) );
			}
			case ( "Knight" ) : {
				return Math.round(( ( new KnightExecute( (Knight)mySelf, myEnemy )).DamageDealWithoutRaceModifier() + (new KnightSlam( (Knight)mySelf, myEnemy )).DamageDealWithoutRaceModifier() ) * terrainAmplifierForKnight ( ((Knight)mySelf).environment ) );
			}
			case ( "Rogue" ) : {
				return Math.round(( ( new RogueBackstab( (Rogue)mySelf, myEnemy )).DamageDealWithoutRaceModifier() + (new RogueParalysis( (Rogue)mySelf, myEnemy )).DamageDealWithoutRaceModifier() ) * terrainAmplifierForRogue ( ((Rogue)mySelf).environment ) );
			}
			default:
				return 0;
		}
	}
	
	public float terrainAmplifierForPyromancer ( char envi ) {
		if ( envi == 'V' ) {
			return (float)1.25;
		}
		return 1;
	}
	
	public float terrainAmplifierForKnight ( char envi ) {
		if ( envi == 'L' ) {
			return (float)1.15;
		}
		return 1;
	}
	
	public float terrainAmplifierForWizard ( char envi ) {
		if ( envi == 'D' ) {
			return (float)1.1;
		}
		return 1;
	}
	
	public float terrainAmplifierForRogue ( char envi ) {
		if ( envi == 'W' ) {
			return (float)1.15;
		}
		return 1;
	}
	
}
