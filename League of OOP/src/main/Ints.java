package main;

public class Ints {
	String string, Nstring = "", Mstring = "";
	char[] stringToChar;
	int[] NM = new int[2];
	int i, j, st = 0;
	
	public Ints(String string) {
		this.string = string;
	}
	
	public Ints(String string, int st) {
		this.string = string;
		this.st = st;
	}
	
	public int[] toArray () {
		stringToChar = string.toCharArray();
		for ( i = st; stringToChar[i] != ' '; i ++ ) {
			Nstring = Nstring.concat(String.valueOf(stringToChar[i]));
		}
		for ( j = i + 1; j < stringToChar.length; j ++ ) {
			Mstring = Mstring.concat(String.valueOf(stringToChar[j]));
		}
		
		NM[0] = Integer.parseInt(Nstring);
		NM[1] = Integer.parseInt(Mstring);
		
		return NM;
	}
}
