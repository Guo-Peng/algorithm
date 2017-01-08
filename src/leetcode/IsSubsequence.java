package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 392. Is Subsequence.
 * Given a string s and a string t, check if s is subsequence of t.
 * <p>
 * You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
 * <p>
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 * <p>
 * Example 1:
 * s = "abc", t = "ahbgdc"
 * <p>
 * Return true.
 * <p>
 * Example 2:
 * s = "axc", t = "ahbgdc"
 * <p>
 * Return false.
 * <p>
 * Follow up:
 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?
 */
public class IsSubsequence {
    /**
     * solution 1 time limit
     * 构造正则进行匹配
     */
    public static boolean isSubsequence1(String s, String t) {
        String reg = ".*";
        for (int i = 0; i < s.length(); i++) reg += s.charAt(i) + ".*";
        return t.matches(reg);

    }

    /**
     * solution 2   354 ms
     * 保存匹配到的所有子序列
     * 遍历检测所有上一轮的子序列
     */
    public static boolean isSubsequence(String s, String t) {
        if (s == null) return false;
        if (s.equals("")) return true;

        HashSet<String> tmp = new HashSet<>();
        HashSet<String> result = new HashSet<>();

        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(0) == t.charAt(i)) result.add(s.charAt(0) + "");

            for (String ele : tmp) {
                if (s.charAt(ele.length()) == t.charAt(i)) {
                    if (ele.length() == s.length() - 1)
                        return true;
                    result.add(ele + s.charAt(ele.length()));
                } else result.add(ele);
            }


            tmp = result;
            result = new HashSet<>();
        }

        return false;
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }
}
