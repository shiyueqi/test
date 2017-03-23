package oj;

/**
 * date: 2017/02/04 14:38.
 * author: Yueqi Shi
 */

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * Example:
 * Given input array nums = [3,2,2,3], val = 3
 * Your function should return length = 2, with the first two elements of nums being 2.
 */
public class RemoveElement_27 {
    public int removeElement(int[] nums, int val) {
        int result = nums.length;
        int index = 0;

        while(index < result) {
            boolean isPlus = true;
            if (nums[index] == val) {
                result--;
                isPlus = false;
                for (int j = index; j < result; j++) {
                    nums[j] = nums[j+1];
                }
            }
            if (isPlus) {
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int result = new RemoveElement_27().removeElement(nums, 3);
        System.out.println(result);
        System.out.println(result);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "->");
        }
    }
}
