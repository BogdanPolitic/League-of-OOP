package main;

public class MapCell {
	int playerOneIndex;
	int playerTwoIndex;
	char environment;
	int round;
	
	public MapCell(int playerOneIndex, int playerTwoIndex, char environment, int round) {
		this.playerOneIndex = playerOneIndex;
		this.playerTwoIndex = playerTwoIndex;
		this.environment = environment;
		this.round = round;
	}
	
}
