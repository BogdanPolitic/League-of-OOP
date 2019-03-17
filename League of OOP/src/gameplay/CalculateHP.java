package gameplay;

import pyromancer.*;
import knight.*;
import wizard.*;
import rogue.*;

public class CalculateHP {
	
	int HPdrop;
	Player player;
	
	public CalculateHP(int hPdrop, Player player) {
		HPdrop = hPdrop;
		this.player = player;
	}
	
	public int returnHP () {
		switch ( player.hero ) {
			case "Pyromancer" :
				return ((Pyromancer)player).hp.CurrentHP;
			case "Knight" :
				return ((Knight)player).hp.CurrentHP;
			case "Wizard" :
				return ((Wizard)player).hp.CurrentHP;
			default: 
				return ((Rogue)player).hp.CurrentHP;
		}
	}
	
	public Player calculateHP () {
		switch ( player.hero ) {
			case "Pyromancer" :
				((Pyromancer)player).hp.CurrentHP -= HPdrop;
				return player;
			case "Knight" :
				((Knight)player).hp.CurrentHP -= HPdrop;
				return player;
			case "Wizard" :
				((Wizard)player).hp.CurrentHP -= HPdrop;
				return player;
			default:
				((Rogue)player).hp.CurrentHP -= HPdrop;
				return player;
		}
	}
	
}
