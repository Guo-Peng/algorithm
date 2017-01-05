package leetcode;

/**
 * 343. Integer Break
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
 * <p>
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 * <p>
 * Note: You may assume that n is not less than 2 and not larger than 58.
 */
public class IntegerBreak {
    /**
     * solution 1 16ms
     * 基于 2 3进行拆解 4可以拆为2 2 5可以拆为 2 3
     * 递归过程中始终保持拆解得到的积最大
     */
    public static int divideInteger(int n) {
        if (n <= 3) return n;
        else return Math.max(2 * divideInteger(n - 2), 3 * divideInteger(n - 3));
    }

    public static int integerBreak(int n) {
        if (n > 3)
            return divideInteger(n);
        else if (n == 3) return 2;
        else return 1;
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
}
