package main.java.kata.pencil;

public class Pencil {
	/*
	 * Constants
	 */
	private static final char CHARACTER_SPACE = ' ';
	private static final char CHARACTER_NEWLINE = '\n';
	private static final char CHARACTER_AT = '@';
	private static final String SPACE_STRING =" ";
	private static final String DOUBLE_SPACE_STRING = "  ";
	
	/*
	 * Member variables
	 */
	private int pointDurability;
	private int originalPointDurability;
	private int length;
	private int eraserDurability;
	
	/*
	 * Constructors
	 */
	public Pencil() {
		
	}
	
	public Pencil(int pointDurability) {
		this.pointDurability = pointDurability;
		this.originalPointDurability = pointDurability;
		this.length = 10;
		this.eraserDurability = 10;
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
	
	/*
	 * Methods
	 */
	public String write(String stringToWrite) {
		String writtenString = new String();
		for (char ch : stringToWrite.toCharArray()) {
			if (pointDurability > 0 && (ch != CHARACTER_NEWLINE && ch != CHARACTER_SPACE)) {
				pointDurability -= Character.isUpperCase(ch) ? 2 : 1;
				writtenString += ch;
			}else {
				writtenString+=SPACE_STRING;
			}
		}
		return writtenString;
	}

	public String append(String originalString, String stringToWrite) {
		return originalString+write(stringToWrite);
	}

	public String erase(String removalString, String targetString) {
		String modifiedString;
		int lastIndexOfStringToBeRemoved = targetString.lastIndexOf(removalString);
		char[] stringToEraseArray = removalString.toCharArray();
		for(int i = stringToEraseArray.length-1; i > -1; i--) {
			if(stringToEraseArray[i] != CHARACTER_SPACE && eraserDurability != 0) {
				eraserDurability-=1;
				stringToEraseArray[i] = CHARACTER_SPACE;
			}
		}
		String erasedString = new String(stringToEraseArray);
		modifiedString = targetString.substring(0, lastIndexOfStringToBeRemoved) + erasedString + targetString.substring(lastIndexOfStringToBeRemoved+removalString.length());
		return modifiedString;
	}

	public void sharpen() {
		if(length > 0) {
			pointDurability = originalPointDurability;
			length-=1;
		}
	}
	
	//this method will insert beginning at the first index of two or more spaces
	public String edit(String stringToInsert, String stringToEdit) {
		int insertStartPosition = stringToEdit.indexOf(DOUBLE_SPACE_STRING)+1;
		char [] stringToEditArray = stringToEdit.toCharArray();
		char [] stringToInsertArray = stringToInsert.toCharArray();
		for(int i = insertStartPosition, j=0; j < stringToInsert.length(); i++, j++) {
			if(stringToEditArray[i] != CHARACTER_SPACE) {
				stringToEditArray[i] = CHARACTER_AT;
			}else {
				stringToEditArray[i] = stringToInsertArray[j];
			}
		}
		return new String (stringToEditArray);
	}
	
	/*
	 * Getters & Setters
	 */
	
	public int getDurability() {
		return pointDurability;
	}
	
	public int getLength() {
		return length;
	}

	public int getEraserDurability() {
		return eraserDurability;
	}
}
