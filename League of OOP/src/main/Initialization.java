package main;

import gameplay.*;

public class Initialization {
	InputInfo inputInfo;
	Player[] Fighters;

	public Initialization ( InputInfo inputInfo ) {
		this.inputInfo = inputInfo;
	}
	
	public Initialization(InputInfo inputInfo, Player[] Fighters) {
		this.inputInfo = inputInfo;
		this.Fighters = Fighters;
	}
	
	MapCell[][] Map, Map0;
	
	MapCell[][] InitializeMapNoPlayers () {
			Map0 = new MapCell[inputInfo.N][inputInfo.M];
		
			for ( int i = 0; i < inputInfo.N; i ++ ) {
				for ( int j = 0; j < inputInfo.M; j ++ ) {
					Map0[i][j] = new MapCell( -1, -1, inputInfo.fieldName[i][j], '_' );
				}
			}
			
			return Map0;
	}
	
	MapCell[][] InitializeMapAndPlayers () {
		Map = this.InitializeMapNoPlayers();
		
		for ( int index = 0; index < inputInfo.P; index ++ ) {
			if ( Fighters[index].emptyHero == false ) {
				if ( Map[inputInfo.initialPositions[index].rand][inputInfo.initialPositions[index].col].playerOneIndex == -1 ) {
					Map[inputInfo.initialPositions[index].rand][inputInfo.initialPositions[index].col].playerOneIndex = index;
				}
				else {
					Map[inputInfo.initialPositions[index].rand][inputInfo.initialPositions[index].col].playerTwoIndex = index;
				}
			}
		}
		
		return Map;
	}
	
}
