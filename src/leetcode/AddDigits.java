package leetcode;

/**
 * 258
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * <p>
 * For example:
 * <p>
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 */
public class AddDigits {
    public static int addDigits1(int num) {
        if (num > 9) {
            int result = 0;
            for (; num > 0; num /= 10) {
                result += num % 10;
            }
            return addDigits(result);
        } else
            return num;
    }

    /**
     * solution 2
     * sum(ai *10^i) 0<=i<=N equals  sum(ai*(10^i-1)) + sum(ai)
     * ai 为第i位数字 sum(ai*(10^i-1)) % 9 ==0
     * 所以 num % 9 == sum(ai) % 9
     */

    public static int addDigits(int num) {
        return num % 9 != 0 ? num % 9 : (num != 0 ? 9 : 0);
    }

    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }
}
