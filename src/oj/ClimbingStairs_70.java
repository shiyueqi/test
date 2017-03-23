package com.unionpay.test.stone.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author shiyueqi
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs_70 {
	
	/**
	 * the first method 
	 * @param n
	 * @return
	 */
	public int climbStairs(int n) {
        
		Map<Integer, Integer> map = new HashMap<>();
		return climbStairs2(n, map);
        
    }
	
	public int climbStairs2(int n, Map<Integer, Integer> map) {
        
        if (n > 2) {
        	
        	if (map.get(n-1) == null) {
        		map.put(n-1, climbStairs2(n-1, map));
        	}
        	
        	if (map.get(n-2) == null) {
        		map.put(n-2, climbStairs2(n-2, map));
        	} 
        	
        	return map.get(n-1) + map.get(n-2); 
        } else if (n == 1) {
        	map.put(1, 1);
        	return 1;
        } else {
        	map.put(2, 2);
        	return 2; 
        }
        
    }

	/**
	 * the second method 
	 * @param n
	 * @return
	 */
	public int climbStairs_method2(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 2;
		}
		
		int nums[] = new int[n-1];
		nums[0] = 1;
		nums[1] = 2;
		
		for (int i = 2; i < n-1; i++) {
			nums[i] = nums[i-1] + nums[i-2];
		}
		
		return nums[n-2] + nums[n-3];
	}
	
	
	
	
	public static void main(String[] args) {
		int n = 44;
		
		long startTime = System.currentTimeMillis();
		System.out.println(startTime);
		
		int ways = new ClimbingStairs_70().climbStairs(n);
		//int ways = new ClimbingStairs_70().climbStairs_method2(n);
		
		long endTime = System.currentTimeMillis();
		System.out.println(endTime);
		
		System.out.println("spend time: " + (endTime - startTime));
		
		System.out.println("result is: " + ways);
	}
}
