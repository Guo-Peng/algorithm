package leetcode.frequency.recursion;

import java.util.HashMap;

/**
 * 246
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * <p>
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 * <p>
 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
 */
public class StrobogrammaticNumber {
    /**
     * solution 1
     * 双指针法,分别从两侧进行检测
     */
    public static boolean isStrobogrammatic(String num) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        map.put('0', '0');

        int l = num.length();
        for (int i = 0; i <= l - i - 1; i++) {
            if (!(map.containsKey(num.charAt(i)) && map.get(num.charAt(i)).equals(num.charAt(l - i - 1))))
                return false;
            System.out.println(String.format("%s -> %S", num.charAt(i), num.charAt(l - i - 1)));
        }
        return true;
    }

    public static void main(String[] args) {
        isStrobogrammatic("16291");
    }
}
