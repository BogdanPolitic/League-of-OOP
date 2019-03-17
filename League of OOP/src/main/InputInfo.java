package main;

public class InputInfo {
	int N;
	int M;
	char[][] fieldName = new char[N][M];
	int P;
	IniPos[] initialPositions = new IniPos[P];
	int R;
	char[][] rounds = new char[R][P];
	
	public InputInfo (int N, int M, char[][] fieldName, int P, IniPos[] initialPositions, int R, char[][] rounds) {
		this.N = N;
		this.M = M;
		this.fieldName = fieldName;
		this.P = P;
		this.initialPositions = initialPositions;
		this.R = R;
		this.rounds = rounds;
	}
}

