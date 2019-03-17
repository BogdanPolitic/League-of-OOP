package gameplay;

import pyromancer.*;
import knight.*;
import wizard.*;
import rogue.*;

public class HeroHP {
	
	Player player;
	
	public HeroHP ( Player player ) {
		this.player = player;
	}
	
	public int outputHP () {
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
	
}
