package solutions.ArraysAndNumbersProblems;

import java.util.Arrays;

public class BestTimetoBuyandSellStockII_122 {
    public int maxProfit(int[] prices) {
        int ans = 0 , n = prices.length;
        int lastBuy = 0;
        if(n==1)
            return 0;
        int i=0;
        while(i<n-1 && prices[i] > prices[i+1])
            i++;
        lastBuy = prices[i++];
        while(i<n){
            while(i<n && prices[i] >= prices[i-1])
                i++;
            ans += (prices[i-1] - lastBuy);

            while(i<n && prices[i] <= prices[i-1])
                i++;
            lastBuy= prices[i-1];
        }
        return ans;
    }
}
