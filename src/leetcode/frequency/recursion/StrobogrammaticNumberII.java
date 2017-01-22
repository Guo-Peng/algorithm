package leetcode.frequency.recursion;

import java.util.*;

/**
 * 247. Strobogrammatic Number II
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * <p>
 * Find all strobogrammatic numbers that are of length = n.
 * <p>
 * For example,
 * Given n = 2, return ["11","69","88","96"].
 * <p>
 * Hint:
 * <p>
 * Try to use recursion and notice that it should recurse with n - 2 instead of n - 1.
 */
public class StrobogrammaticNumberII {
    /**
     * solution 1
     * 按位插入数字,完成一半即可
     * dfs
     */
    static HashMap<Character, Character> map = new HashMap<>();

    public static void findStrobogrammaticByBit(int n, int N, StringBuilder num, List<String> result) {
        for (Map.Entry<Character, Character> entry : map.entrySet()) {
            if (n == 0 && entry.getKey().equals('0') && N != 1)
                continue;

            if (N % 2 == 1 && n == N / 2 && !entry.getKey().equals(entry.getValue()))
                continue;

            StringBuilder tmpNum = new StringBuilder(num);
            tmpNum.setCharAt(n, entry.getKey());
            tmpNum.setCharAt(N - n - 1, entry.getValue());

            if ((N % 2 == 0 && n == (N / 2 - 1)) || (N % 2 == 1 && n == N / 2))
                result.add(tmpNum.toString());
            else
                findStrobogrammaticByBit(n + 1, N, tmpNum, result);
        }
    }

    public static List<String> findStrobogrammatic(int n) {
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        map.put('0', '0');

        List<String> result = new ArrayList<>();
        StringBuilder initNum = new StringBuilder();
        initNum.setLength(n);
        findStrobogrammaticByBit(0, n, initNum, result);
        return result;
    }

    public static void main(String[] args) {
        List<String> list = findStrobogrammatic(1);
        for (String num : list) {
            System.out.println(num);
        }
    }
}
