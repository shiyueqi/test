package oj;

/**
 * date: 2016/09/23 13:40.
 * author: Yueqi Shi
 */

import java.util.Arrays;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne_66 {
    public int[] plusOne(int[] digits) {
        int[] res = new int[digits.length+1];

        boolean isPlusOne = Boolean.TRUE;
        for (int i = digits.length - 1; i >= 0; i--) {
            int resNum = digits[i];
            if (isPlusOne) {
                 resNum++;
            }

            if (resNum >= 10) {
                res[i+1] = resNum - 10;
                isPlusOne = true;
            } else {
                res[i+1] = resNum;
                isPlusOne = false;
            }
        }

        if (isPlusOne) {
            res[0] = 1;
        } else {
            int[] res2 = new int[digits.length];
            for (int i = 1; i < res.length; i++) {
                res2[i-1] = res[i];
            }

            return res2;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] digits = new int[]{9,9};
        int[] res = new PlusOne_66().plusOne(digits);
        System.out.println(Arrays.toString(res));
    }
}
