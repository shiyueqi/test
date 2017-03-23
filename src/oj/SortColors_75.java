package com.unionpay.test.stone.leetcode;

import java.util.Arrays;

/**
 * @author shiyueqi
 * Given an array with n objects colored red, white or blue, sort them so that objects of the 
 * same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 * click to show follow up.
 *
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, 
 * then 1's and followed by 2's.
 * Could you come up with an one-pass algorithm using only constant space?
 */
public class SortColors_75 {

	public void sortColors(int[] nums) {
        int[] counts = {0, 0, 0};
        
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] == 0) {
        		counts[0] = ++counts[0];
        	} else if (nums[i] == 1) {
        		counts[1] = ++counts[1];
        	} else if (nums[i] == 2) {
        		counts[2] = ++counts[2];
        	}
        }
        
        for (int i = 0; i < counts[0]; i++) {
        	nums[i] = 0;
        }
        
        for (int i = 0; i < counts[1]; i++) {
        	nums[i+counts[0]] = 1;
        }
        
        for (int i = 0; i < counts[2]; i++) {
        	nums[i + counts[0] + counts[1]] = 2;
        }
        
    }
	
	public static void main(String[] args) {
		int nums[] = {1,2,0,1,0,1,1,0,2,0,2,1,1,2,2,2,2,0};
		
		new SortColors_75().sortColors(nums);
		
		System.out.println(Arrays.toString(nums));
		
	}

}
