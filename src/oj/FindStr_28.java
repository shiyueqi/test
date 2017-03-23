package oj;

/**
 * date: 2016/09/26 13:40.
 * author: Yueqi Shi
 */

/**
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class FindStr_28 {
    public int strStr(String haystack, String needle) {
        if (haystack == null
                || needle == null) {
            return -1;
        }

        int needleLength = needle.length();
        String tempStr = "";

        for (int i = 0; i <= haystack.length() - needleLength; i++) {
            tempStr = haystack.substring(i, i+needleLength);

            if (tempStr.equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}
