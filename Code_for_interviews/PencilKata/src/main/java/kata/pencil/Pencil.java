package main.java.kata.pencil;

public class Pencil {
	private int durability;
	
	public Pencil() {
		
	}
	
	public Pencil(int durability) {
		this.durability = durability;
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
}
