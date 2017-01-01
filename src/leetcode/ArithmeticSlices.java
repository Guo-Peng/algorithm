package leetcode;

/**
 * 413. Arithmetic Slices
 * A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 * <p>
 * For example, these are arithmetic sequence:
 * <p>
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * The following sequence is not arithmetic.
 * <p>
 * 1, 1, 2, 5, 7
 * <p>
 * A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.
 * <p>
 * A slice (P, Q) of array A is called arithmetic if the sequence:
 * A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.
 * <p>
 * The function should return the number of arithmetic slices in the array A.
 * <p>
 * <p>
 * Example:
 * <p>
 * A = [1, 2, 3, 4]
 * <p>
 * return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
 */
public class ArithmeticSlices {

    /**
     * solution 1   2ms
     * 检测连续的最大序列后计算该序列的slice的个数 此时 j = index + 1
     * 然后检测 index   index + 1   index + 2是否符合
     */
    public static int numberOfArithmeticSlices1(int[] A) {
        int count = 0;
        if (A.length < 3) return count;

        for (int i = 0, j = 2; i < A.length - 2; i = j - 2) {
            while (j < A.length && (A[j - 1] - A[j - 2]) == (A[j] - A[j - 1])) {
                j += 1;
            }

            if (j >= i + 3) {
                int n = j - i - 2;
                count += n * (n + 1) / 2;
            }
            j += 1;
        }
        return count;
    }

    /**
     * solution 2   2ms
     * 仍然是一次检测最大序列,cur负责指示序列的长度 cur
     * 检测失败后cur归零重新检测
     */
    public static int numberOfArithmeticSlices(int[] A) {
        int curr = 0, sum = 0;
        for (int i = 2; i < A.length; i++)
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                curr += 1;
                sum += curr;
            } else {
                curr = 0;
            }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 8, 9, 10};
        System.out.println(numberOfArithmeticSlices(arr));
    }
}
