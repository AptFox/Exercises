package main.java.kata.pencil;

public class Pencil {
	private int pointDurability;
	private int originalPointDurability;
	private int length;
	private int eraserDurability;
	
	public Pencil(int pointDurability) {
		this.pointDurability = pointDurability;
		this.originalPointDurability = pointDurability;
		this.length = 10;
	}
	
	public Pencil(int pointDurability, int pencilLength) {
		this.pointDurability = pointDurability;
		this.originalPointDurability = pointDurability;
		this.length = pencilLength;
	}

	public Pencil(int pointDurability, int pencilLength, int eraserDurability) {
		this.pointDurability = pointDurability;
		this.originalPointDurability = pointDurability;
		this.length = pencilLength;
		this.eraserDurability = eraserDurability;
	}

	public String write(String stringToWrite) {
		String writtenString = "";
		for (char ch : stringToWrite.toCharArray()) {
			if (pointDurability > 0 && (ch != '\n' && ch != ' ')) {
				pointDurability -= Character.isUpperCase(ch) ? 2 : 1;
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
		return pointDurability;
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
		if(length > 0) {
			pointDurability = originalPointDurability;
			length-=1;
		}
	}

	public int getLength() {
		return length;
	}

	public int getEraserDurability() {
		return eraserDurability;
	}
}
