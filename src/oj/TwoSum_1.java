package com.unionpay.test.stone.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author shiyueqi
 *  Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    You may assume that each input would have exactly one solution.
    Example:
    Given nums = [2, 7, 11, 15], target = 9,

	Because nums[0] + nums[1] = 2 + 7 = 9,
	return [0, 1].
	UPDATE (2016/2/13):
	The return format had been changed to zero-based indices. Please read the above updated description carefully.
 */
public class TwoSum_1 {
	public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
        	int value = map.get(nums[i]) == null ? 0 : map.get(nums[i]);
        	
        	map.put(nums[i], ++value);
        }
        
        int sum2 = 0;
        boolean isMany = false;
        
        for (int i = 0; i < nums.length; i++) {
        	sum2 = target - nums[i];
        	
        	Integer value = map.get(sum2);
        	
        	if (value == null) {
        		continue;
        	}
        	
        	if (sum2 != nums[i]) {
        		res[0] = i;
        		break;
        	}
        	
        	if (sum2 == nums[i] && value > 1) {
        		res[0] = i;
        		isMany = true;
        		break;
        	} else {
        		continue;
        	}
        }
        
        
        
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] == sum2) {
        		if (isMany) {
        			isMany = false;
        			continue;
        		}
        		
        		res[1] = i;
        		break;
        	}
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		int[] nums = {3, 2, 4};
		int target = 6;
		
		int[] res = new TwoSum_1().twoSum(nums, target);
		
		System.out.println(res[0]+"||"+res[1]);
	}
}
