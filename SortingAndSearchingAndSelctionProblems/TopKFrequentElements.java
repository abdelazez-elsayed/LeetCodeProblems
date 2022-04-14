package solutions.SortingAndSearchingAndSelctionProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    static class Pair{
        int num;
        int freq;
        Pair(int n,int f){
            num = n;
            freq = f;
        }

    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>((p1, p2) -> p2.freq - p1.freq);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Pair p = new Pair(entry.getKey(), entry.getValue());
            queue.add(p);
        }
        int[] sol = new int[k];
        for(int i=0;i<k;i++){
            sol[i] = Objects.requireNonNull(queue.poll()).num;
        }
        return sol;
    }
}
