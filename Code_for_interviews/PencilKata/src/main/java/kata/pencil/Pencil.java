package main.java.kata.pencil;

public class Pencil {
	public String write(String stringToWrite) {
		return stringToWrite;
	}

	public String append(String originalString, String stringToWrite) {
		return originalString+write(stringToWrite);
	}
}
