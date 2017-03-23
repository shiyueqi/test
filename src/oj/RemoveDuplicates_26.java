package oj;

/**
 * date: 2017/02/04 14:01.
 * author: Yueqi Shi
 */

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once
 * and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 *
 * For example,
 * Given input array nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the new length.
 */
public class RemoveDuplicates_26 {
    public int removeDuplicates(int[] nums) {
        int result = nums.length;

        int index = 0;
        while (index < result) {
            boolean isPlus = true;
            for (int i = 0; i < index; i++) {
                if (nums[index] == nums[i]) {
                    isPlus = false;
                    result--;
                    for (int j = index; j < result; j++) {
                        nums[j] = nums[j+1];
                    }
                }
            }
            if (isPlus) {
                index++;
            }
//
//            System.out.println("****index:" + index + "****");
//            for (int i = 0; i < nums.length; i++) {
//                System.out.print(nums[i] + "->");
//            }
//            System.out.println();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,4,5,2,3,6,7,8,7};
        int result = new RemoveDuplicates_26().removeDuplicates(nums);
        System.out.println(result);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "->");
        }
    }
}
