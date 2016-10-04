package leetcode;

/**
 * 344
 * Write a function that takes a string as input and returns the string reversed.
 * <p>
 * Example:
 * Given s = "hello", return "olleh".
 */
public class ReverseString {

    /**
     * solution 1
     * 使用stringbuilder的reverse方法
     */
    public static String reverseString1(String s) {
        if (s == null || s.equals("")) return s;
        return new StringBuffer(s).reverse().toString();
    }

    /**
     * solution
     * 转化为char数组并调换
     */
    public static String reverseString(String s) {
        if (s == null || s.length() < 2) return s;
        char[] ch = s.toCharArray();
        for (int i = 0, j = ch.length - 1; i <= j; i++, j--) {
            char tmp = ch[i];
            ch[i] = ch[j];
            ch[j] = tmp;
        }
        return new String(ch);
    }

    public static void main(String[] args) {
        System.out.println(reverseString("hello"));
    }
}
