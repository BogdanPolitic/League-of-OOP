package gameplay;

public class Player {
	public boolean emptyHero = true;
	public String hero;
	boolean lifeStatus;
	public int level;
	public int xp;
	public int round;
	public Overtime overtime;
	public Overtime overtimePrevRound;
	public int numberOfAttacks = 0;
	
	public Player(String hero, boolean lifeStatus, int level, int xp, int round, Overtime overtime, Overtime overtimePrevRound) {
		this.hero = hero;
		this.lifeStatus = lifeStatus;
		this.level = level;
		this.xp = xp;
		this.round = round;
		this.overtime = overtime;
		this.overtimePrevRound = overtimePrevRound;
		emptyHero = false;
	}
	
}
