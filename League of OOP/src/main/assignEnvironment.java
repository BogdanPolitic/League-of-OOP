package main;

import gameplay.*;
import pyromancer.*;
import knight.*;
import wizard.*;
import rogue.*;

public class assignEnvironment {
	Player player;
	char environment;
	
	public assignEnvironment(Player player, char environment) {
		this.player = player;
		this.environment = environment;
	}
	
	public Player assignEnvironmentToPlayer () {
		switch ( player.hero ) {
			case "Pyromancer" :
				((Pyromancer)player).environment = environment;
				return player;
			case "Knight" :
				((Knight)player).environment = environment;
				return player;
			case "Wizard" :
				((Wizard)player).environment = environment;
				return player;
			default :
				((Rogue)player).environment = environment;
				return player;
		}
	}
	
}
