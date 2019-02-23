import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
	public static int add(int a, int b) {
		return a+b;	
	}
	
	public static int sum(List<Integer> inputList) {
		int sum = 0;
		
		for(int i : inputList) {
			sum= add(i, sum);
		}
		return sum;
	}
	
	private static List<Integer> parseStringToIntList(String csv){
		String[] csvArr = csv.split(",");
		Integer[] intArr = new Integer[csvArr.length];
		for(int i= 0; i <= csvArr.length-1; i++) {
			try {
				intArr[i] = Integer.parseInt(csvArr[i]);
			}catch(NumberFormatException e) {
				intArr[i] = 0;
			}
		}
		return new ArrayList<Integer>(Arrays.asList(intArr));
	}
	
	public static int sum(String csv) {
		List<Integer> intList = parseStringToIntList(csv);
		return sum(intList);
	}
	
	
}	
