package oj;

/**
 * Created by shiyueqi on 2016/7/25.
 */

/**
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

 * Try to solve it in linear time/space.

 * Return 0 if the array contains less than 2 elements.

 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 * 求排序之后的最大差异！！
 * 使用桶排序！！！
 */

/**
 * TestCases: [3,6,9,1]
 */
public class MaximumGap_164 {
    public int maximumGap(int[] nums) {
        if(nums.length < 2)
            return 0;

        int maximumGap = 0;

        for(int i=0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1]){
                maximumGap = nums[i] - nums[i+1] > maximumGap ? nums[i] - nums[i+1] : maximumGap;
            }else {
                maximumGap = nums[i+1] - nums[i] > maximumGap ? nums[i+1] - nums[i] : maximumGap;
            }
        }
        return maximumGap;
    }
}
