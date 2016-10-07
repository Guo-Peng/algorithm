package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 136
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumber {
    /**
     * solution 1 8ms
     * 先排序,数字切换后如果count不为1则返回
     */
    public static int singleNumber1(int[] nums) {
        Arrays.sort(nums);
        int pre = -1, count = -1;
        for (int num : nums) {
            if (pre != num)
                if (count != 0) {
                    pre = num;
                    count = 0;
                } else return pre;
            else count++;
        }
        return pre;
    }

    /**
     * solution 2  2ms   best
     * 异或操作
     */
    public static int singleNumber2(int[] nums) {
        int c = 0;
        for (int num : nums) {
            c ^= num;
        }
        return c;
    }


    /**
     * solution 3  17ms
     * 依次添加至set中,若包含则删除
     */
    public static int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.remove(num)) set.add(num);
        }
        return set.iterator().next();
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 3, 3, 4, 4, 6, 6, 8, 8};
        System.out.println(singleNumber(arr));
    }
}
