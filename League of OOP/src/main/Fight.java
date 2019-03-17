package main;

import gameplay.*;

public class Fight {
	
	InputInfo inputInfo;
	MapCell[][] Map;
	Player[] Fighters;
	int round;
	
	public Fight(InputInfo inputInfo, MapCell[][] Map, Player[] fighters, int round) {
		this.inputInfo = inputInfo;
		this.Map = Map;
		this.Fighters = fighters;
		this.round = round;
	}
	
	public InputInfo ChangeFightersPositions () {
		for ( int i = 0; i < inputInfo.P; i ++ ) {
			if ( Fighters[i].overtime.SlamMovementIncapacity.equals("noEffect") && Fighters[i].overtime.ParalysisOvertimeRounds == 0 && Fighters[i].emptyHero == false ) {
				if ( inputInfo.rounds[round][i] == 'U' ) {
					inputInfo.initialPositions[i].rand --;
				}
				
				if ( inputInfo.rounds[round][i] == 'R' ) {
					inputInfo.initialPositions[i].col ++;
				}
				
				if ( inputInfo.rounds[round][i] == 'D' ) {
					inputInfo.initialPositions[i].rand ++;
				}
				
				if ( inputInfo.rounds[round][i] == 'L' ) {
					inputInfo.initialPositions[i].col --;
				}
			}
		}
		
		return inputInfo;
		
	}
	
	public Player[] FindTwoCombatants () {
		Initialization init = new Initialization ( inputInfo, Fighters );
		Map = init.InitializeMapAndPlayers();
		
		for ( int i = 0; i < inputInfo.N; i ++ ) {
			for ( int j = 0; j < inputInfo.M; j ++ ) {
				if ( Map[i][j].playerOneIndex != -1 && Map[i][j].playerTwoIndex != -1 ) {
					Fighters[Map[i][j].playerOneIndex] = ( new assignEnvironment ( Fighters[Map[i][j].playerOneIndex], Map[i][j].environment )).assignEnvironmentToPlayer();
					Fighters[Map[i][j].playerTwoIndex] = ( new assignEnvironment ( Fighters[Map[i][j].playerTwoIndex], Map[i][j].environment )).assignEnvironmentToPlayer();
					
					FightLocation fightLocation = new FightLocation(i, j);
					FightingHeroes startFIGHT = new FightingHeroes ( fightLocation, inputInfo, Map, Fighters, round );
					Fighters = startFIGHT.StartFIGHT();
				}
				
				if ( Map[i][j].playerOneIndex != -1 && Map[i][j].playerTwoIndex == -1 ) {
					
					Fighters[Map[i][j].playerOneIndex] = ( new assignEnvironment ( Fighters[Map[i][j].playerOneIndex], Map[i][j].environment )).assignEnvironmentToPlayer();
					FightLocation fightLocation = new FightLocation (i, j);
					Fighters[Map[i][j].playerOneIndex] = ( new ConsumingOvertime ( fightLocation, inputInfo, Fighters[Map[i][j].playerOneIndex], round ) ).Start();
					Fighters[Map[i][j].playerOneIndex].overtime = ( (new OvertimeEffects ( Fighters[Map[i][j].playerOneIndex] )).effects() ).overtime;
				}
				
				if ( Map[i][j].playerOneIndex == -1 && Map[i][j].playerTwoIndex != -1 ) {
					Fighters[Map[i][j].playerTwoIndex] = ( new assignEnvironment ( Fighters[Map[i][j].playerTwoIndex], Map[i][j].environment )).assignEnvironmentToPlayer();
					FightLocation fightLocation = new FightLocation (i, j);
					Fighters[Map[i][j].playerTwoIndex] = ( new ConsumingOvertime ( fightLocation, inputInfo, Fighters[Map[i][j].playerTwoIndex], round ) ).Start();
					Fighters[Map[i][j].playerTwoIndex].overtime = ( (new OvertimeEffects ( Fighters[Map[i][j].playerTwoIndex] )).effects() ).overtime;
				}
			}
		}
		
		return Fighters;
		
	}
	
}
