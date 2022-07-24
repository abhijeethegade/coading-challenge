/**
 * 
 * @author Abhijeet
 *
 *Problem statement : Given an integer array nums, 
 *                    find the contiguous subarray (containing at least one number) 
 *                    which has the largest sum and return its sum.
 */

public class MaxSubArray {

	public static void main(String[] args) {
		
		int[] input = {-2,1,-3,4,-1,2,1,-5,4};
		
		int result = findMaxSubArray(input);
		
		System.out.print("Maximum sum of subarray :" +result);
	}
	
	public static int findMaxSubArray(int[] input) {
		
		int currentMaxSum = 0;
		int prevMaxSum =0;
		
		for(int i=0; i< input.length; i++) {
			
			prevMaxSum += input[i];
		
			if(currentMaxSum < prevMaxSum) {
				currentMaxSum = prevMaxSum;
			}
			if(prevMaxSum < 0) {
				prevMaxSum = 0;
			}
		}
		
		return currentMaxSum;
	}

}
