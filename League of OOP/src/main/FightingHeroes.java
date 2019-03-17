package main;

import gameplay.*;

public class FightingHeroes {
	
	int i, j;
	InputInfo inputInfo;
	MapCell[][] Map;
	Player[] Fighters;
	int round;
	
	public FightingHeroes(FightLocation fightLocation, InputInfo inputInfo, MapCell[][] Map, Player[] fighters, int round) {
		this.i = fightLocation.rand;
		this.j = fightLocation.col;
		this.inputInfo = inputInfo;
		this.Map = Map;
		this.Fighters = fighters;
		this.round = round;
	}
	
	public Player[] StartFIGHT () {
		
		int DamageDealtByPlayer1 = 0, DamageDealtByPlayer2 = 0, DamageDealtByPlayer1NoRaceModifiers = 0, DamageDealtByPlayer2NoRaceModifiers = 0;
		
		OvertimeAndHPdrop overtimeAndHPdrop1 = (new OvertimeEffects ( Fighters[Map[i][j].playerOneIndex] )).effects();
		OvertimeAndHPdrop overtimeAndHPdrop2 = (new OvertimeEffects ( Fighters[Map[i][j].playerTwoIndex] )).effects();
		
		Fighters[Map[i][j].playerOneIndex].overtime = overtimeAndHPdrop1.overtime;
		Fighters[Map[i][j].playerTwoIndex].overtime = overtimeAndHPdrop2.overtime;
		
		int hpDrop1 = overtimeAndHPdrop1.HPdrop;
		int hpDrop2 = overtimeAndHPdrop2.HPdrop;
		
		Fighters[Map[i][j].playerOneIndex] = (new CalculateHP(hpDrop1, Fighters[Map[i][j].playerOneIndex])).calculateHP();
		Fighters[Map[i][j].playerTwoIndex] = (new CalculateHP(hpDrop2, Fighters[Map[i][j].playerTwoIndex])).calculateHP();
		
		if ( (new CalculateHP(hpDrop1, Fighters[Map[i][j].playerOneIndex])).returnHP() <= 0 )
			Fighters[Map[i][j].playerOneIndex].emptyHero = true;
		if ( (new CalculateHP(hpDrop1, Fighters[Map[i][j].playerTwoIndex])).returnHP() <= 0 )
			Fighters[Map[i][j].playerTwoIndex].emptyHero = true;
		
		if ( Fighters[Map[i][j].playerOneIndex].emptyHero == false && Fighters[Map[i][j].playerTwoIndex].emptyHero == false ) {
			if ( Fighters[Map[i][j].playerOneIndex].hero != "Wizard" && Fighters[Map[i][j].playerTwoIndex].hero != "Wizard" ) {
				DamageDealtByPlayer1 = ( ( new CalculateDamage ( Fighters[Map[i][j].playerOneIndex], Fighters[Map[i][j].playerTwoIndex] ) ) ).calculate();
				DamageDealtByPlayer2 = ( ( new CalculateDamage ( Fighters[Map[i][j].playerTwoIndex], Fighters[Map[i][j].playerOneIndex] ) ) ).calculate();
			}
			if ( Fighters[Map[i][j].playerOneIndex].hero != "Wizard" && Fighters[Map[i][j].playerTwoIndex].hero == "Wizard" ) {
				DamageDealtByPlayer1NoRaceModifiers = ( ( new CalculateDamage ( Fighters[Map[i][j].playerOneIndex], Fighters[Map[i][j].playerTwoIndex] ) ) ).calculateWithoutRaceModifier();
				DamageDealtByPlayer1 = ( ( new CalculateDamage ( Fighters[Map[i][j].playerOneIndex], Fighters[Map[i][j].playerTwoIndex] ) ) ).calculate();
				DamageDealtByPlayer2 = ( ( new CalculateDamage ( Fighters[Map[i][j].playerTwoIndex], Fighters[Map[i][j].playerOneIndex], DamageDealtByPlayer1NoRaceModifiers ) ) ).calculate();
			}
			if ( Fighters[Map[i][j].playerOneIndex].hero == "Wizard" && Fighters[Map[i][j].playerTwoIndex].hero != "Wizard" ) {
				DamageDealtByPlayer2NoRaceModifiers = ( ( new CalculateDamage ( Fighters[Map[i][j].playerTwoIndex], Fighters[Map[i][j].playerOneIndex] ) ) ).calculateWithoutRaceModifier();
				DamageDealtByPlayer2 = ( ( new CalculateDamage ( Fighters[Map[i][j].playerTwoIndex], Fighters[Map[i][j].playerOneIndex] ) ) ).calculate();
				DamageDealtByPlayer1 = ( ( new CalculateDamage ( Fighters[Map[i][j].playerOneIndex], Fighters[Map[i][j].playerTwoIndex], DamageDealtByPlayer2NoRaceModifiers ) ) ).calculate();
			}
			if ( Fighters[Map[i][j].playerOneIndex].hero == "Wizard" && Fighters[Map[i][j].playerTwoIndex].hero == "Wizard" ) {
				DamageDealtByPlayer1 = ( ( new CalculateDamage ( Fighters[Map[i][j].playerOneIndex], Fighters[Map[i][j].playerTwoIndex], 0 ) ) ).calculate();
				DamageDealtByPlayer2 = ( ( new CalculateDamage ( Fighters[Map[i][j].playerTwoIndex], Fighters[Map[i][j].playerOneIndex], 0 ) ) ).calculate();
			}
		}
		else {
			DamageDealtByPlayer2 = DamageDealtByPlayer1 = 0;
			DamageDealtByPlayer1NoRaceModifiers = DamageDealtByPlayer2NoRaceModifiers = 0;
			return Fighters;
		}
		
		Fighters[Map[i][j].playerOneIndex].numberOfAttacks ++;
		Fighters[Map[i][j].playerTwoIndex].numberOfAttacks ++; 
		
		Fighters[Map[i][j].playerOneIndex].overtime = ( new GetOvertime (Fighters[Map[i][j].playerOneIndex], Fighters[Map[i][j].playerTwoIndex]) ).getOvertime();
		Fighters[Map[i][j].playerTwoIndex].overtime = ( new GetOvertime (Fighters[Map[i][j].playerTwoIndex], Fighters[Map[i][j].playerOneIndex]) ).getOvertime();

		Fighters[Map[i][j].playerOneIndex] = (new CalculateHP(DamageDealtByPlayer2, Fighters[Map[i][j].playerOneIndex])).calculateHP();
		Fighters[Map[i][j].playerTwoIndex] = (new CalculateHP(DamageDealtByPlayer1, Fighters[Map[i][j].playerTwoIndex])).calculateHP();

		int player1HP = (new CalculateHP(DamageDealtByPlayer2, Fighters[Map[i][j].playerOneIndex])).returnHP();
		int player2HP = (new CalculateHP(DamageDealtByPlayer1, Fighters[Map[i][j].playerTwoIndex])).returnHP();
		
		if ( player1HP > 0 && player2HP <= 0 ) {
			Fighters[Map[i][j].playerTwoIndex].emptyHero = true;
			Fighters[Map[i][j].playerOneIndex].xp += Math.max(0, 200 - ( Fighters[Map[i][j].playerOneIndex].level - Fighters[Map[i][j].playerTwoIndex].level ) * 40 );
			Fighters[Map[i][j].playerOneIndex] = ( new Level(Fighters[Map[i][j].playerOneIndex]) ).readyForLevelUp();
		}
		if ( player1HP <= 0 && player2HP > 0 ) {
			Fighters[Map[i][j].playerOneIndex].emptyHero = true;
			Fighters[Map[i][j].playerTwoIndex].xp += Math.max(0, 200 - ( Fighters[Map[i][j].playerTwoIndex].level - Fighters[Map[i][j].playerOneIndex].level ) * 40 );
			Fighters[Map[i][j].playerTwoIndex] = ( new Level(Fighters[Map[i][j].playerTwoIndex]) ).readyForLevelUp();
		}
		if ( player1HP <= 0 && player2HP <= 0 ) {
			Fighters[Map[i][j].playerOneIndex].emptyHero = Fighters[Map[i][j].playerOneIndex].emptyHero = true;
		}
		
		Fighters[Map[i][j].playerOneIndex].round ++;
		Fighters[Map[i][j].playerTwoIndex].round ++;
		
		return Fighters;
		
	}
	
}
