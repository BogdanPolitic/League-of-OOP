package knight;

import gameplay.*;

public class Knight extends Player {
	public HP hp;
	public char environment;
	
	public Knight(String hero, boolean lifeStatus, int level, int xp, int round, Overtime overtime, Overtime overtimePrevRound, HP hp, char environment) {
		super(hero, lifeStatus, level, xp, round, overtime, overtimePrevRound);
		this.hp = hp;
		this.environment = environment;
	}
	
	public void Initialize () {
		hp.BasicHP = hp.CurrentHP = 900 + 80 * level;
	}
	
}
