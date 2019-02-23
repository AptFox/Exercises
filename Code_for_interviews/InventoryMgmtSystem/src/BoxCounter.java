import java.util.Arrays;

public class BoxCounter {
	
	public int doubleLetterCount;
	public int tripleLetterCount;

	public void CountLetters(String boxLabel) {
		char[] charArr = boxLabel.toCharArray();
		Arrays.sort(charArr);
		
		int tempDoubleCount = 0;
		int tempTripleCount = 0;
		
		//differentiate from 3
		char lastSeenChar = charArr[0];
		for(int i = 1; i < charArr.length; i++) {
			if(charArr[i] == lastSeenChar) {
				if(i < charArr.length-1 && charArr[i] == charArr[i+1] && tempTripleCount < 1) {
					tempTripleCount+=1;
					i++;
				}else{
					tempDoubleCount+=1;
				}

			}
			lastSeenChar = charArr[i];
		}
		doubleLetterCount+=tempDoubleCount;
		tripleLetterCount+=tempTripleCount;
		
	}

}
