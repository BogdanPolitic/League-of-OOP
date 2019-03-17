package rogue;

import gameplay.*;

public class Rogue extends Player {
	
	public HP hp;
	public char environment;
	
	public Rogue(String hero, boolean lifeStatus, int level, int xp, int round, Overtime overtime, Overtime overtimePrevRound, HP hp, char environment) {
		super(hero, lifeStatus, level, xp, round, overtime, overtimePrevRound);
		this.hp = hp;
		this.environment = environment;
	}
	
	public void initialize () {
		hp.BasicHP = hp.CurrentHP = 600 + 40 * level;
	}
	
}
