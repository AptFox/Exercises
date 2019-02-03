package main.java.kata.pencil;

public class Pencil {
	private int durability;
	
	public Pencil() {
		
	}
	
	public Pencil(int durability) {
		this.durability = durability;
	}

	public String write(String stringToWrite) {
		return stringToWrite;
	}

	public String append(String originalString, String stringToWrite) {
		return originalString+write(stringToWrite);
	}

	public int getDurability() {
		return durability;
	}
}
