package wizard;

import gameplay.*;

public class Wizard extends Player {
	
	public HP hp;
	public char environment;
	
	public Wizard(String hero, boolean lifeStatus, int level, int xp, int round, Overtime overtime, Overtime overtimePrevRound, HP hp, char environment) {
		super(hero, lifeStatus, level, xp, round, overtime, overtimePrevRound);
		this.hp = hp;
		this.environment = environment;
	}
	
	public void Initialize () {
		hp.BasicHP = hp.CurrentHP = 400 + 30 * level;
	}
	
}
