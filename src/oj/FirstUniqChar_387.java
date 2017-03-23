package com.unionpay.test.stone.oj;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author shiyueqi
 *
 */
/**
 *  Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

	Examples:

	s = "leetcode"
	return 0.

	s = "loveleetcode",
	return 2.
	Note: You may assume the string contain only lowercase letters.
 *
 */
@SuppressWarnings("unused")
public class FirstUniqChar_387 {
	public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap();
        
        for (int i = 0; i < s.length(); i++) {
            Integer value = map.get(s.charAt(i));
            if (value == null) {
                map.put(s.charAt(i), 1);    
            } else {
                map.put(s.charAt(i), ++value);
            }
        }
        
        for (int i = 0; i < s.length(); i++) {
            Integer value = map.get(s.charAt(i));
            
            if (value == 1) {
                return i;
            } else {
                continue;
            }
        }
        
        return -1;
    }
	
	public static void main(String[] args) {
    	String s = "loveleetcodevtcd";
    	String s2 = "loveleetcode";
    	
    	int res = new FirstUniqChar_387().firstUniqChar(s);
    	
    	System.out.println(res);
    }
}
