package leetcode;

/**
 * 260
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 * <p>
 * For example:
 * <p>
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 */
public class SingleNumberIII {
    /**
     * 4ms
     * 得出a^b = xor
     * 找出xor为0的最低位mask,该位上a b相异
     * 将数组分为于mask相&结果不同的两个组,则两个数组分别归为两个组
     * 组内进行xor即可得出两个数组
     */
    public static int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        int xor = 0;

        for (int n : nums) {
            xor ^= n;
        }

        int mask = 1;
        while ((xor & mask) == 0) {
            mask = mask << 1;
        }

        int num1 = 0;
        int num2 = 0;

        for (int num : nums) {
            if ((num & mask) > 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }

        result[0] = num1;
        result[1] = num2;
        System.out.println(num1 + "\t" + num2);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1};
        System.out.println(singleNumber(arr));
    }
}
