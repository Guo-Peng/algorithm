package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 412
 * Write a program that outputs the string representation of numbers from 1 to n.
 * <p>
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
 * <p>
 * Example:
 * <p>
 * n = 15,
 * <p>
 * Return:
 * [
 * "1",
 * "2",
 * "Fizz",
 * "4",
 * "Buzz",
 * "Fizz",
 * "7",
 * "8",
 * "Fizz",
 * "Buzz",
 * "11",
 * "Fizz",
 * "13",
 * "14",
 * "FizzBuzz"
 * ]
 */
public class FizzBuzz {
    public static List<String> fizzBuzz(int n) {
        List<String> result = new LinkedList<>();
        String tmp;
        for (int x = 1; x <= n; x++) {
            if (x % 3 == 0) tmp = "Fizz";
            else tmp = "";
            if (x % 5 == 0) tmp += "Buzz";
            if (tmp.equals("")) tmp = String.valueOf(x);
            result.add(tmp);
        }
        return result;
    }

    public static void main(String[] args) {
        for (String s : fizzBuzz(15)) {
            System.out.println(s);
        }
    }
}
