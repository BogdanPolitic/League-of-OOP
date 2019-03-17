package gameplay;

public class Overtime {
	public int IgniteOvertimeRounds = 0;
	public int IgniteOvertimeDamage = 0;
	public String SlamMovementIncapacity = "noEffect";
	public int ParalysisOvertimeRounds = 0;
	public Damage ParalysisOvertimeIncapacityAndDamage = new Damage(0);
	
	public Overtime() {
		
	}
	
	public Overtime(int igniteOvertimeRounds, int ignireOvertimeDamage, String slamMovementIncapacity,
			int paralysisOvertimeRounds, Damage paralysisOvertimeIncapacityAndDamage) {
		IgniteOvertimeRounds = igniteOvertimeRounds;
		IgniteOvertimeDamage = ignireOvertimeDamage;
		SlamMovementIncapacity = slamMovementIncapacity;
		ParalysisOvertimeRounds = paralysisOvertimeRounds;
		ParalysisOvertimeIncapacityAndDamage = paralysisOvertimeIncapacityAndDamage;
	}
	
}
