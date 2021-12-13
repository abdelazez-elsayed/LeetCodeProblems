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
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        List<Interval> ans = new LinkedList<>();
        intervals.sort(Comparator.comparingInt(o -> o.start));
        Interval pre = null;
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
