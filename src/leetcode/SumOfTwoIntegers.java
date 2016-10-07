package leetcode;

/**
 * 371
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * <p>
 * Example:
 * Given a = 1 and b = 2, return 3.
 */

public class SumOfTwoIntegers {
    /**
     * soltion 1  9ms
     * 逐位相加
     */
    public static char[] bitAdd(char a, char b) {
        if (a == b) return new char[]{a, '0'};
        else return new char[]{'0', '1'};
    }

    public static int getSum1(int a, int b) {
        String aStr = Integer.toBinaryString(a);
        String bStr = Integer.toBinaryString(b);
        int len = aStr.length() > bStr.length() ? aStr.length() : bStr.length();
        char[] aBin = String.format("%" + len + "s", aStr).replace(' ', '0').toCharArray();
        char[] bBin = String.format("%" + len + "s", bStr).replace(' ', '0').toCharArray();
        char[] result = new char[aBin.length];
        char tmp = '0';
        for (int i = aBin.length - 1; i >= 0; i--) {
            char[] first = bitAdd(aBin[i], bBin[i]);
            char[] second = bitAdd(first[1], tmp);

            tmp = (char) ((int) first[0] | (int) second[0]);
            result[i] = second[1];
        }
        if (len < 32 && tmp == '1')
            return Integer.parseUnsignedInt('1' + new String(result), 2);

        return Integer.parseUnsignedInt(new String(result), 2);
    }

    /**
     * solution 2  1ms
     * 每bit: result = a^b ,carry(进位) = a&b
     * 不断将进位左移并产生新的结果和进位,直至进位为0
     */
    public static int getSum(int a, int b) {
        int carry = a & b;
        int result = a ^ b;
        while (carry != 0) {
            int carry_t = carry << 1;
            carry = carry_t & result;
            result = result ^ carry_t;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(getSum(1, -5));
    }
}
