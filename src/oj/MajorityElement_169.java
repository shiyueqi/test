package oj;

/**
 * Created by shiyueqi on 2016/7/22.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ? n/2 ? times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement_169 {

    public int majorityElement(int[] nums) {
        int majorityElement = 0;

        Map<Integer, Integer> numsMap = new HashMap<>();
        int maxTimes = 0;

        for(int i=0; i<nums.length; i++){
            Integer numTimes = numsMap.get(nums[i]);
            if(numTimes == null){
                numTimes = 0;
            }

            numsMap.put(nums[i], ++numTimes);

            if(numTimes > maxTimes){
                maxTimes = numTimes;
                majorityElement = nums[i];
            }
        }

        return majorityElement;
    }

    public static void main(String[] args){
        MajorityElement_169 majorityElementObj = new MajorityElement_169();
        int[] nums = {3,3,4};
        int majorityElement = majorityElementObj.majorityElement(nums);
        System.out.println(majorityElement);
    }
}
