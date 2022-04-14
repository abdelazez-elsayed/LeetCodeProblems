package solutions.GeneralProblems;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinTimeToBuildAllBlocks {
    class Worker implements Comparable<Worker>{
        public int block;
        public int split;
        int cost;
        public Worker(int b , int sp,int c){
            block = b;
            split = sp;
            cost = c;
        }

        @Override
        public int compareTo(Worker o) {
            return (this.split*cost+block)-(o.split*o.cost+o.block);
        }
    }
    int minTime(int[] blocks, int cost){
        Arrays.sort(blocks);
        int n = blocks.length;
        PriorityQueue<Worker> pq = new PriorityQueue<>();
        pq.add(new Worker(blocks[n-1],0,cost));
        int ans=0;
        for(int i=n-2;i>=0;--i){
            Worker w = pq.poll();
            Worker newW = new Worker(blocks[i],w.split+1,cost);
            w.split++;
            pq.add(w);
            pq.add(newW);
            ans = Math.max(ans,Math.max(w.split*cost+w.block,newW.split*cost+newW.block));
        }


        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,5,2};
        int c = 2;
        MinTimeToBuildAllBlocks m = new MinTimeToBuildAllBlocks();
        System.out.println(m.minTime(arr,c));
    }
}
