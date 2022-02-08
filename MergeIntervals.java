package solutions;

import java.util.*;

public class MergeIntervals {
    public class Interval {
      int start, end;
      Interval(int start, int end) {
         this.start = start;
          this.end = end;
      }
  }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(e -> e[0]));
        int[] pre = null;
        List<int[]> ans = new LinkedList<>();
        for(int[] interval : intervals){
            if(pre == null)
                pre = interval;
            if(pre[1] < interval[1]) {
                ans.add(pre);
                pre[0] = interval[0];
            }else{
                pre[1]  = Math.max(pre[1],interval[1]);
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        List<Interval> ans = new LinkedList<>();
        intervals.sort(Comparator.comparingInt(o -> o.start));
        Interval pre = null;
        List<int[]> l = new LinkedList<>();
        for (Interval curr : intervals) {
            if (pre == null) {
                pre = curr;
            } else {
                if (pre.end < curr.start) {
                    ans.add(pre);
                    pre = curr;
                } else {
                    pre.end = Math.max(pre.end, curr.end);
                }
            }
        }
        if (pre != null) {
            ans.add(pre);
        }
        return ans;
    }
}
