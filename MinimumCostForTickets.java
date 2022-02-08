package solutions;

import java.util.Arrays;

public class MinimumCostForTickets {
    int[] mem;
    int[] len = {1,7,30};
    int[] days;
    int[] costs;
    int n;
    public int mincostTickets(int[] days, int[] costs) {
        mem = new int[days.length];
        this.days= days;
        this.costs=costs;
        this.n = days.length;
        return helper(0);
    }
    int helper(int idx){
        if(idx >= n){
            return 0;
        }
        if(mem[idx] != 0)
            return mem[idx];
        if(idx == n-1)
            return mem[idx] = min(costs);
        int min_val = Integer.MAX_VALUE;
        for(int i=0; i<3; i++){
            int period = len[i];
            int cost = costs[i];
            int j=idx+1;
            while(j < n && days[j] < days[idx]+period )
                j++;
            min_val = Math.min(min_val,cost+helper(j));
        }
        return mem[idx] = min_val;
    }
    int min(int[] arr){
        int ans = Integer.MAX_VALUE;
        for(int num : arr){
            if(num < ans)
                ans = num;
        }
        return ans;
    }
    public static void main(String[] args) {
        MinimumCostForTickets m = new MinimumCostForTickets();
        int days[] = {1,2,3,4,5,6,7,8,9,10,30,31};
        int[] costs = {2,7,15};
        int ans = m.mincostTickets(days,costs);
        System.out.println(ans);
    }
}
