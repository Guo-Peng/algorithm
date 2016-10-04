package CodingInterviews.chapter2;

/**
 * 二维数组中的查找
 * 从数组的左下、右上进行排除查找
 */
public class NumFind {
    public static boolean find(int[][] a, int num) {
        if (a.length == 0)
            return false;

        int row = 0;
        int column = a[0].length - 1;
        while (row >= 0 & row < a.length & column >= 0) {
            int current = a[row][column];
            if (num == current)
                return true;
            else if (num > current)
                row += 1;
            else column -= 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15},
        };

        int[][] b = {};

        System.out.println(find(b, 0));
    }
}
