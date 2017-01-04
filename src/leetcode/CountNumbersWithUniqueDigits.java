package leetcode;

import java.util.HashSet;

/**
 * 357. Count Numbers with Unique Digits
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10^n.
 * <p>
 * Example:
 * Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
 */
public class CountNumbersWithUniqueDigits {

    /**
     * solution 1  0ms
     * n = 0 时 为 1
     * 1位为C 9 1
     * 2 位为 C 9 1 * C 9 1
     * 3 位为 C 9 1 * C 9 1 * C 8 1
     */
    public static int countNumbersWithUniqueDigits1(int n) {
        if (n == 0) return 1;
        int count = 9;
        for (int i = 9, bit = n; bit >= 2; i--, bit--)
            count *= i;
        return count + countNumbersWithUniqueDigits(n - 1);
    }

    /**
     * solution 2
     * 大于10为之后不用计算
     */
    public static int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;

        int count = 10, base = 9;
        for (int i = 2; i <= n && i <= 10; i++) {
            base *= (9 - i + 2);
            count += base;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(2));
    }
}
