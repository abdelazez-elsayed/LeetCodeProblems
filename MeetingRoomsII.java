package solutions;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public int minMeetingRooms(List<MergeIntervals.Interval> intervals) {
        // Write your code here
        intervals.sort(Comparator.comparingInt(e -> e.start));
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int cnt = 0;
        int ans = 1;
        for(MergeIntervals.Interval interval : intervals){
            while(!heap.isEmpty() && heap.peek() < interval.start){
                heap.poll();
                cnt--;
            }
            cnt++;
            heap.add(interval.end);
            ans= Math.max(ans,cnt);
        }
        return ans;
    }
}
