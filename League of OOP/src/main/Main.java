package main;

import gameplay.*;

public class Main {

	public static void main(String[] args) {
		
		InputToString in = new InputToString(args[0]);
		InputInfo inputInfo = in.Reads();
		
		Player[] Fighters = new Player[inputInfo.P];
		MapCell[][] Map;
		
		Fighters = ( new InitializeFighters ( Fighters, inputInfo.P, inputInfo.initialPositions )).initializeFighters();
		Map = ( new Initialization ( inputInfo, Fighters ) ).InitializeMapAndPlayers();
		
		for ( int round = 0; round < inputInfo.R; round ++ ) {
			inputInfo = (new Fight (inputInfo, Map, Fighters, round)).ChangeFightersPositions();
			Map = ( new Initialization ( inputInfo, Fighters ) ).InitializeMapAndPlayers();	
			Fighters = (new Fight (inputInfo, Map, Fighters, round)).FindTwoCombatants();
		}
		
		( new OutputInfo ( args[1], inputInfo, Fighters ) ).output();
		
	}

}
