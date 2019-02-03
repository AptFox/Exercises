package main.java.kata.pencil;

public class Pencil {
	private int durability;
	private int originalDurability;
	private int length;
	
	public Pencil(int durability) {
		this.durability = durability;
		this.originalDurability = durability;
		this.length = 10;
	}
	
	public Pencil(int durability, int length) {
		this.durability = durability;
		this.originalDurability = durability;
		this.length = length;
	}

	public String write(String stringToWrite) {
		String writtenString = "";
		for (char ch : stringToWrite.toCharArray()) {
			if (durability > 0 && (ch != '\n' && ch != ' ')) {
				durability -= Character.isUpperCase(ch) ? 2 : 1;
				writtenString += ch;
			}else {
				writtenString+=" ";
			}
		}
		return writtenString;
	}

	public String append(String originalString, String stringToWrite) {
		return originalString+write(stringToWrite);
	}

	public int getDurability() {
		return durability;
	}

	public String erase(String removalString, String targetString) {
		String modifiedString;
		String emptySpaceReplacement = "";
		int lastIndexOf = targetString.lastIndexOf(removalString);
		for(int i=0; i <removalString.length(); i++) {
			emptySpaceReplacement+=" ";
		}
		modifiedString = targetString.substring(0, lastIndexOf) + 
				emptySpaceReplacement + 
				targetString.substring(lastIndexOf+removalString.length());
		return modifiedString;
	}

	public void sharpen() {
		durability = originalDurability;
	}

	public int getLength() {
		return length;
	}
}
