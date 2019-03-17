package main;

import gameplay.*;

import java.io.FileNotFoundException;
import java.util.Formatter;

public class OutputInfo {
	
	String fileName;
	InputInfo finalInfo;
	Player[] fighters;
	
	public OutputInfo(String fileName, InputInfo finalInfo, Player[] fighters) {
		this.fileName = fileName;
		this.finalInfo = finalInfo;
		this.fighters = fighters;
	}
	
	Formatter x;
	
	public void output () {
		
		try {
			x = new Formatter ( fileName );
			
			for ( int i = 0; i < finalInfo.P; i ++ ) {
				int heroHP = ( new HeroHP ( fighters[i] ) ).outputHP();
				
				if ( heroHP > 0 )
					x.format( "%c %d %d %d %d %d", (fighters[i].hero).charAt(0), fighters[i].level, fighters[i].xp, heroHP, finalInfo.initialPositions[i].rand, finalInfo.initialPositions[i].col );
				else
					x.format( "%c %s", (fighters[i].hero).charAt(0), "dead" );
				
				if ( i != finalInfo.P - 1 ) {
					x.format( "\n" );
				}
			}
			x.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
}
