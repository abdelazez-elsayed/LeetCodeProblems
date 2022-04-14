package solutions.GeneralProblems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TheNumberOfTheSmallestUnoccupiedChair {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        PriorityQueue<Integer> chairs= new PriorityQueue<>();
        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(p -> p.lv_time));

        int targetArriveTime = times[targetFriend][0];

        Arrays.sort(times, Comparator.comparingInt(e -> e[0]));
        for(int i=0; i<n ; i++)
            chairs.add(i);

        for(int[] t : times){
            int arrive = t[0];
            int leave = t[1];
            while(!queue.isEmpty() && queue.peek().lv_time <= arrive){

                Pair leaver = queue.poll();
                chairs.add(leaver.chair);
            }
            int chair = chairs.poll();
            if(arrive == targetArriveTime)
                return chair;
            Pair enter = new Pair(chair, leave);
            queue.add(enter);
        }
        return -1;
    }
    static class Pair{
        int chair,lv_time;
        Pair(int c , int t){
            this.chair= c;
            this.lv_time =t;
        }
    }
}
