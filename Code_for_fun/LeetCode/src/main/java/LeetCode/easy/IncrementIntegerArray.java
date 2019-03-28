/*
 * Prompt: Given an array of Integers which represents a number, 
 * write a function that takes this array and adds one to it and returns it as an array.  
 */

package main.java.LeetCode.easy;

public class IncrementIntegerArray {
	public static int[] incrementArrayNum(int[] num) {  // O(n+n) = O(n)
		int carry =1; 
		for(int i = num.length-1; i > 0; i--) { // O(n) where n is the num of ints in num
			if(num[i]+ carry == 10) {
				num[i] = 0;
				carry = 1;
			}else {
				num[i]+= carry;
				carry = 0;
			}
		}
		if(carry != 0) {
			int[] tmpArr = new int[num.length+1];
			tmpArr[0] = carry;
			for(int i = 1; i < tmpArr.length-1; i++) { // O(n) where n is the num of ints in num
				tmpArr[i] = 0;
			}
			num = tmpArr;
		}
		return num;
	}
}
