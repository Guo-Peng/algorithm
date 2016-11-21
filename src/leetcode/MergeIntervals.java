package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */


class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    public void print() {
        System.out.println("[" + start + "," + end + "]");
    }
}

public class MergeIntervals {
    /*
     * solution 1  33 ms
     *
     */
    static class com implements Comparator<Interval> {
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 2)
            return intervals;
        intervals.sort(new com());
        List<Interval> result = new ArrayList<>();
        Interval pre = null;
        for (Interval cur : intervals) {
            if (pre == null) {
                pre = cur;
                result.add(pre);
            } else {
                if (pre.end >= cur.start) {
                    if (pre.end < cur.end)
                        pre.end = cur.end;
                } else {
                    pre = cur;
                    result.add(pre);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>(Arrays.asList(new Interval(1, 4), new Interval(2, 3)));
        List<Interval> result = merge(intervals);
        for (Interval i : result) {
            i.print();
        }
    }
}
