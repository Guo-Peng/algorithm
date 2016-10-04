package leetcode;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 * <p>
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 * <p>
 * Follow up:
 * <p>
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 */

public class CountingBits {
    /**
     * solution 1
     * 依次检测每一位
     */
    public static int count1(int num) {
        int count = 0;
        while (num > 0) {
            count += num % 2;
            num /= 2;
        }
        return count;
    }

    public static int[] countBits1(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++)
            result[i] = count1(i);
        return result;
    }

    /**
     * solution 2
     * 移位引用已有的结果
     */
    public static int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; i++)
            result[i] = result[i >> 1] + (i & 1);
        return result;
    }

    public static void main(String[] args) {
        for (int n : countBits(10)) {
            System.out.println(n);
        }
    }
}
