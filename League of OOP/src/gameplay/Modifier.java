package gameplay;

public class Modifier {
	int Rogue;
	int Knight;
	int Pyromancer;
	int Wizard;
	String hero;
	
	
	
	public Modifier(int rogue, int knight, int pyromancer, int wizard, String hero) {
		Rogue = rogue;
		Knight = knight;
		Pyromancer = pyromancer;
		Wizard = wizard;
		this.hero = hero;
	}



	public int Modify () {
		if ( hero.equals("Rogue")) {
			return Rogue;
		}
		if ( hero.equals("Knight")) {
			return Knight;
		}
		if ( hero.equals("Pyromancer")) {
			return Pyromancer;
		}
		return Wizard;
	}
}
