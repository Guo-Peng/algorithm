package leetcode;

import java.util.*;
import java.util.stream.IntStream;

/**
 * 406
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
 * <p>
 * Note:
 * The number of people is less than 1,100.
 * <p>
 * Example
 * <p>
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * <p>
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class QueueReconstructionByHeight {
    static class com implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] > o2[0]) return 1;
            else if (o1[0] < o2[0]) return -1;
            else if (o1[1] > o2[1]) return 1;
            else if (o1[1] < o2[1]) return -1;
            else return 0;
        }
    }

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new com());
        int[][] queue = new int[people.length][2];
        ArrayList<Integer> index = new ArrayList<Integer>();
        for (int i = 0; i < people.length; i++)
            index.add(i);

        int[] count = {-1, -1};
        for (int[] element : people) {
            if (count[0] == element[0]) count[1]++;
            else {
                count[0] = element[0];
                count[1] = 0;
            }

            int i = index.remove(element[1] - count[1]);
            queue[i] = element;
        }

        return queue;
    }

    public static void print(int[][] people) {
        for (int[] element : people) {
            System.out.println(element[0] + "\t" + element[1]);
        }
    }

    public static void main(String[] args) {
        int[][] a = {{7, 0}, {4, 4}, {7, 1}, {5, 2}, {6, 1}, {5, 0}};
        int[][] s = reconstructQueue(a);
        print(s);

        int[] r = IntStream.range(0, 10).toArray();
        for (int i : r) System.out.println(i);
    }
}
