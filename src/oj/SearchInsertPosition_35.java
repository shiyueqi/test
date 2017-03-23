package oj;

/**
 * date: 2017/02/10 14:22.
 * author: Yueqi Shi
 */

/**
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Here are few examples.
 * [1,3,5,6], 5 ¡ú 2
 * [1,3,5,6], 2 ¡ú 1
 * [1,3,5,6], 7 ¡ú 4
 * [1,3,5,6], 0 ¡ú 0
 */
public class SearchInsertPosition_35 {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }

        return nums.length;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 0;

        int res = new SearchInsertPosition_35().searchInsert(nums, target);
        System.out.println(res);
    }
}
