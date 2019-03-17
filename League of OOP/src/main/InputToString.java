package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InputToString {
	String buffer = "", argIn;
	InputInfo inputInfo;
	
	public InputToString (String argIn) {
		this.argIn = argIn;
	}
	
	public InputInfo Reads () {
		int i, j;
		int N;
		int M;
		int[] NM = new int[2];
		char[][] fieldName;
		int P;
		IniPos[] initialPositions;
		int R;
		char[][] rounds;
		
		char rasa;
		int rand, col;
		
		try {
			FileReader fIn = new FileReader(argIn);
			BufferedReader scanner = new BufferedReader(fIn);
			Ints NandM = new Ints(scanner.readLine());
			NM = NandM.toArray();
			N = NM[0];
			M = NM[1];
			fieldName = new char[N][M];
			for ( i = 0; i < N; i ++ ) {
				for ( j = 0; j < M; j ++ ) {
					fieldName[i][j] = (char)(scanner.read());
				}
				if ( scanner.read() == 13 ) {
					scanner.read();
				}
			}
			int chr = scanner.read();
			while ( chr < 48 || chr > 57 ) {
				chr = scanner.read();
			}
			String jmp = (String.valueOf((char)chr)).concat(scanner.readLine());
			P = Integer.parseInt(jmp);
			initialPositions = new IniPos[P];
			Ints RANDandCOL;
			for ( i = 0; i < P; i ++ ) {
				rasa = (char)(scanner.read());
				scanner.read();
				RANDandCOL = new Ints(scanner.readLine(), 0);
				NM = RANDandCOL.toArray();
				rand = NM[0];
				col = NM[1];
				initialPositions[i] = new IniPos(rasa, rand, col);
			}
			R = Integer.parseInt(scanner.readLine());
			rounds = new char[R][P];
			for ( i = 0; i < R; i ++ ) {
				for ( j = 0; j < P; j ++ ) {
					rounds[i][j] = (char)(scanner.read());
				}
				if ( scanner.read() == 13 ) {
					scanner.read();
				}
			}

			fIn.close();
			
			return new InputInfo(N, M, fieldName, P, initialPositions, R, rounds);
		}
		catch (FileNotFoundException e) {
			System.out.println("Opening file error.");
		}
		catch (IOException e) {
			System.out.println("Scrii cu picioarele asa urat si citesti asa prost incat iti da astia IOError.");
		}
		return new InputInfo(0, 0, new char[1][1], 0, new IniPos[1], 0, new char[1][1]);
	}
}
