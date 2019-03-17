package gameplay;

public class OvertimeEffects {
	
	Player player;
	int hpDrop = 0;
	public OvertimeAndHPdrop overtimeAndHPdrop;
	
	public OvertimeEffects ( Player player ) {
		this.player = player;
	}
	
	public OvertimeAndHPdrop effects () {
		
		if ( player.overtime.IgniteOvertimeRounds != 0 ) {
			player.overtime.IgniteOvertimeRounds --;
			hpDrop = player.overtime.IgniteOvertimeDamage;
		}
		
		if ( player.overtime.SlamMovementIncapacity.equals("triggered") ) {
			player.overtime.SlamMovementIncapacity = "onEffect";
		}
		else if ( player.overtime.SlamMovementIncapacity.equals("onEffect") ) { 
			player.overtime.SlamMovementIncapacity = "noEffect";
		}
		
		if ( player.overtime.ParalysisOvertimeRounds != 0 ) {
			player.overtime.ParalysisOvertimeRounds --;
			hpDrop = player.overtime.ParalysisOvertimeIncapacityAndDamage.damage;
		}
		
		overtimeAndHPdrop = ( new OvertimeAndHPdrop(player.overtime, hpDrop));
		
		return overtimeAndHPdrop;
		
	} 
	
}
