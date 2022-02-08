package solutions;

import java.util.Arrays;

public class CapacityToShipWithinDDays {
    int[][] dp;
    int n;
    int[] w;
    int[] prefix_sum;
    //O(N^2 * days)
    public int shipWithinDays(int[] weights, int days) {
        n= weights.length;
        w=weights;
        dp = new int[n+1][days+1];
        prefix_sum = new int[n+1];
        for(int i=1;i<=n;i++){
            prefix_sum[i] = prefix_sum[i-1]+w[i-1];
        }
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return find(0,days);
    }
    int find(int i,int days){
        if(dp[i][days] != -1)
            return dp[i][days];
        if(days == 1){
            return dp[i][days] = prefix_sum[n] - prefix_sum[i];
        }
        int minLargestSplit = Integer.MAX_VALUE;
        for (int j = i; j <= n - days; j++) {
            // Store the sum of the first subarray.
            int firstSplitSum = prefix_sum[j + 1] - prefix_sum[i];

            // Find the maximum subarray sum for the current first split.
            int largestSplitSum = Math.max(firstSplitSum,
                    find(j + 1, days - 1));

            // Find the minimum among all possible combinations.
            minLargestSplit = Math.min(minLargestSplit, largestSplitSum);

            if (firstSplitSum >= minLargestSplit) {
                break;
            }
        }

        return dp[i][days] = minLargestSplit;
    }

    public static void main(String[] args) {
        int[] weights = {1,2,3,1,1};
        int days = 4;
        CapacityToShipWithinDDays c = new CapacityToShipWithinDDays();
        System.out.println(c.shipWithinDays(weights,days));

    }
}
