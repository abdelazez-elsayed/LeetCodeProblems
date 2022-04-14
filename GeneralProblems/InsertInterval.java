package solutions.GeneralProblems;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i=0, n = intervals.length;
        ArrayList<int[]> list = new ArrayList<>();
        while(i<n && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i++]);
        }
        while(i<n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        list.add(newInterval);
        while(i < n)
            list.add(intervals[i++]);

        return list.toArray(new int[list.size()][]);

    }

    public static void main(String[] args) {
        int[][] itv2 = {{1,5}};
        int[] ne2 = {0,3};
        int[][] itv = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] ne = {4  ,8};
        InsertInterval i = new InsertInterval();
        int[][] res = i.insert(itv2,ne2);
        for(int[] arr : res)
             System.out.print(Arrays.toString(arr)+",");
    }
}
