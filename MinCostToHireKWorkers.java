package solutions;

import java.util.*;

public class MinCostToHireKWorkers {
    class Pair{
        double ratio;
        int wage;
        Pair(double r , int w){
            ratio = r;
            wage = w;
        }
    }
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n= wage.length;
        Pair[] workers = new Pair[n];
        for(int i=0; i<n; i++)
            workers[i] = (new Pair((double) wage[i] / quality[i],quality[i]));
        Arrays.sort(workers, Comparator.comparingDouble(e -> e.ratio));
        double sum =0, ans = 0;
        PriorityQueue<Integer> minQualities = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<k; i++){
            minQualities.add(workers[i].wage);
            sum += workers[i].wage;
        }
        ans = sum * workers[k-1].ratio;
        for(int i=k; i<n; i++){
            int maxQuality = minQualities.peek();
            if(maxQuality > workers[i].wage){
                minQualities.poll();
                minQualities.add(workers[i].wage);
                sum += workers[i].wage - maxQuality;
            }
            ans = Math.min(ans, workers[i].ratio * sum);
        }
        return ans;

    }
}
