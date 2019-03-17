package main;
import gameplay.*;
import pyromancer.*;
import knight.*;
import wizard.*;
import rogue.*;

public class InitializeFighters {
	Player[] Fighters;
	int numberOfFighters;
	IniPos[] Positions;
	
	public InitializeFighters(Player[] fighters, int numberOfFighters, IniPos[] positions) {
		this.Fighters = fighters;
		this.numberOfFighters = numberOfFighters;
		this.Positions = positions;
	}
	
	public Player[] initializeFighters () {
		Fighters = new Player[numberOfFighters];
		for ( int i = 0; i < numberOfFighters; i ++ ) {
			switch ( Positions[i].rasa ) {
				case 'P' :
					Fighters[i] = new Pyromancer("Pyromancer", true, 0, 0, 0, new Overtime(), new Overtime(), new HP(500, 500), '_');
					break;
				case 'K' :
					Fighters[i] = new Knight("Knight", true, 0, 0, 0, new Overtime(), new Overtime(), new HP(900, 900), '_');
					break;
				case 'W' :
					Fighters[i] = new Wizard("Wizard", true, 0, 0, 0, new Overtime(), new Overtime(), new HP(400, 400), '_');
					break;
				default :
					Fighters[i] = new Rogue("Rogue", true, 0, 0, 0, new Overtime(), new Overtime(), new HP(600, 600), '_');
					break;
			}
		}
		return Fighters;
	}
}
