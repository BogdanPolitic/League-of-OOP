package gameplay;

import pyromancer.*;
import knight.*;
import wizard.*;
import rogue.*;

public class Level {
	
	Player player;

	public Level(Player player) {
		this.player = player;
	}
	
	public Player readyForLevelUp () {
		
		int level = 0;
		
		if ( player.xp >= 250 )
			level = ( player.xp - 250 ) / 50 + 1;
		
		if ( level > player.level ) {
			switch ( player.hero ) {
				case "Pyromancer" :
					((Pyromancer)player).hp.BasicHP += 50 * (level - player.level);
					((Pyromancer)player).hp.CurrentHP = ((Pyromancer)player).hp.BasicHP;
					break;
				case "Knight" :
					((Knight)player).hp.BasicHP += 80 * (level - player.level);
					((Knight)player).hp.CurrentHP = ((Knight)player).hp.BasicHP;
					break;
				case "Wizard" :
					((Wizard)player).hp.BasicHP += 30 * (level - player.level);
					((Wizard)player).hp.CurrentHP = ((Wizard)player).hp.BasicHP;
					break;
				case "Rogue" :
					((Rogue)player).hp.BasicHP += 40 * (level - player.level);
					((Rogue)player).hp.CurrentHP = ((Rogue)player).hp.BasicHP;
					break;
			}
			player.level = level;
		}
		
		return player;
	}
	
}
