package oj;

/**
 * date: 2017/02/10 16:25.
 * author: Yueqi Shi
 */

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 *
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 *
 * Note: The sequence of integers will be represented as a string.
 */
public class CountAndSay_38 {
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }

        String resStr = "1";
        String tempStr;
        int tempIndex;
        for (int index = 1; index < n; index++) {
            tempStr = "";
            for (int i = 0; i < resStr.length();) {
                char preChar = resStr.charAt(i);
                tempIndex = i;
                while(tempIndex < resStr.length()) {
                    if (++tempIndex < resStr.length()
                            && resStr.charAt(tempIndex) == preChar) {
                        continue;
                    } else {
                        tempStr += String.valueOf((tempIndex-i));
                        tempStr += preChar;
                        break;
                    }
                }

                i = tempIndex;
            }

            resStr = tempStr;
        }

        return resStr;
    }

    public static void main(String[] args) {
        int n = 18;
        String res = new CountAndSay_38().countAndSay(n);
        System.out.println(res);
    }
}
