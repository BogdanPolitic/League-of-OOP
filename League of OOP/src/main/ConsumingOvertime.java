package main;

import gameplay.*;

public class ConsumingOvertime {
	int i, j;
	InputInfo inputInfo;
	Player player;
	int round;
	
	public ConsumingOvertime(FightLocation fightLocation, InputInfo inputInfo, Player player, int round) {
		this.i = fightLocation.rand;
		this.j = fightLocation.col;
		this.inputInfo = inputInfo;
		this.player = player;
		this.round = round;
	}
	
	public Player Start() {
		player.round ++;
		OvertimeAndHPdrop overtimeAndHPdrop = (new OvertimeEffects ( player )).effects();
		player.overtime = overtimeAndHPdrop.overtime;
		int hpDrop = overtimeAndHPdrop.HPdrop;
		if ( (new CalculateHP ( hpDrop, player )).returnHP() <= 0 ) {
			player.emptyHero = true;
		}
		return ( (new CalculateHP ( hpDrop, player )).calculateHP() );
	}
	
}
