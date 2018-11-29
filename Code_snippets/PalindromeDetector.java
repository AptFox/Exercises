
public class PalindromeDetector {
	
	public static boolean isPalindrome(char [] arr){
		boolean result = true;
		
		if (arr.length != 0){
			int j = 1;
			char [] arr2 = new char [arr.length];
			for (int i = 0; i < arr.length; i++){
				arr2[i] = arr[arr.length-j];
				j++;
			}
			j = 1;
			for (int i = 0; i < arr.length; i++){
				if (arr[i] != arr2[i]){
					result = false;
				}
				j++;
			}
		}
		
		return result;
	}

}
