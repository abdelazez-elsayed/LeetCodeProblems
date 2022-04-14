package solutions;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (e1, e2) -> e1[0] == e2[0] ? e2[1]-e1[1] : e1[0]-e2[0]);
        int n = intervals.length;
        int cnt = n;
        for(int i=0; i < intervals.length;){
            int[] prev = intervals[i];
            while(i+1 < n && intervals[i+1][1] <= prev[1]){
                cnt--;
                i++;
            }
            i++;
        }
        return cnt;
    }
}
