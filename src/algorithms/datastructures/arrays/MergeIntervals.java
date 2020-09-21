package algorithms.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        List list = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; i++) {
            if (i + 1 < intervals.length && intervals[i][1] >= intervals[i + 1][0]) {
                intervals[i + 1][0] = intervals[i][0];
                intervals[i + 1][1] = intervals[i + 1][1];
                list.add(intervals[i + 1]);
                i++;
            } else {
                list.add(intervals[i]);
            }
        }
        return (int[][]) list.toArray(new int[list.size()][]);
        //return arr;
    }

    public static void main(String[] args) {
        //[ [1,3]
        // ,[2,6]
        // ,[8,10]
        // ,[15,18]]
        int arr[][] = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        int arr[][] = {{1,4}, {4,5}};
        int res[][] = merge(arr);
        for (int r[] : res) {
            System.out.println("{" + r[0] + "," + r[1] + "}");
        }
    }
}
