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
     * 分解后的数为均值时乘积最大 x^(n/x) 求导得到最值点为e 尽量拆为2 或者3必有最大值
     * <p>
     * solution 1 16ms
     * 基于 2 3进行拆解 4可以拆为2 2 5可以拆为 2 3
     * 递归过程中始终保持拆解得到的积最大
     */
    public static int divideInteger(int n) {
        if (n <= 3) return n;
        else return Math.max(2 * divideInteger(n - 2), 3 * divideInteger(n - 3));
    }

    public static int integerBreak1(int n) {
        if (n > 3)
            return divideInteger(n);
        else if (n == 3) return 2;
        else return 1;
    }

    /**
     * solution 2   3ms
     * 每一位依次拆解 并保存拆解最大值
     */
    public int integerBreak2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], (Math.max(j, dp[j])) * (Math.max(i - j, dp[i - j])));
            }
        }
        return dp[n];
    }

    /**
     * solution 3  1ms
     * 修改最优解
     * 可以只拆解 2 3
     */
    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j < i && j < 4; j++) {
                dp[i] = Math.max(dp[i], (Math.max(j, dp[j])) * (Math.max(i - j, dp[i - j])));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
}
