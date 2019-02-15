package main.java.LeetCode.easy;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] foundIndices = new int[2];
        for(int i =0; i < nums.length-1; i++){
            for(int j=i+1; j < nums.length; j++){
                if((nums[i]+nums[j]) == target){
                    foundIndices[0] = i;
                    foundIndices[1] = j;
                    break;
                }
            }
        }
        return foundIndices;
    }
}
