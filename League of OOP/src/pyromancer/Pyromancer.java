package pyromancer;

import gameplay.*;

public class Pyromancer extends Player {
	public HP hp;
	public char environment;
	
	public Pyromancer(String hero, boolean lifeStatus, int level, int xp, int round, Overtime overtime, Overtime overtimePrevRound, HP hp, char environment) {
		super(hero, lifeStatus, level, xp, round, overtime, overtimePrevRound);
		this.hp = hp;
		this.environment = environment;
	}
	
	public void Initialize () {
		hp.CurrentHP = hp.BasicHP = 500 + 50 * level;
	}
	
}
