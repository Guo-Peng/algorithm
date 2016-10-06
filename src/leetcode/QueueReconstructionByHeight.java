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
    /**
     * solution 1  29ms
     * 按照height排序后,key的值即为元素在剩余位置的索引
     * 如果出现相同的height则索引需要减去count
     */
    static class com implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] == o2[0])
                return o1[1] - o2[1];
            else
                return o1[0] - o2[0];
        }
    }

    public static int[][] reconstructQueue1(int[][] people) {
        Arrays.sort(people, new com());
        print(people);
        int[][] queue = new int[people.length][2];
        ArrayList<Integer> index = new ArrayList<>();
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

    /**
     * solution 2  insert 89ms
     * 从大到小直接根据key插入list中
     * 后续插入的小元素不会影响大元素的位置
     * 相同height key较大的必然出现在其之后
     * sort 可由 PriorityQueue 代替
     */
    public static int[][] reconstructQueue(int[][] people) {
        if (people.length == 0 || people[0].length == 0) return people;
        int n = people.length;
        Arrays.sort(people, (int[] a, int[] b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            else
                return b[0] - a[0];
        });

        List<int[]> list = new ArrayList<>();
        for (int[] pos : people) {
            list.add(pos[1], pos);
        }

        return list.toArray(new int[n][2]);
    }

    public static void print(int[][] people) {
        for (int[] element : people)
            System.out.println(element[0] + "\t" + element[1]);
        System.out.println("");
    }

    public static void main(String[] args) {
        int[][] a = {{7, 0}, {4, 4}, {7, 1}, {5, 2}, {6, 1}, {5, 0}};
        int[][] s = reconstructQueue(a);
        print(s);
    }
}
