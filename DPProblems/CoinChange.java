package solutions.DPProblems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CoinChange {
    int[] memo;
    int n;
    int[] coins;
    int am;
    Set<Integer> set;
    public int coinChange(int[] coins, int amount) {
        n = coins.length;
        am = amount;
        this.coins = coins;
        memo = new int[am+1];
        set = new HashSet<>();
        for(int coin : coins){
            set.add(coin);
        }
        return dp(amount);
    }
    int dp(int amount){
        if(amount < 0)
            return -1;
        if(set.contains(amount))
            return 1;
        if(memo[amount] != 0)
            return memo[amount];
        int res = Integer.MAX_VALUE;
        for(int coin : coins) {
            int ans = dp(amount - coin);
            if (ans == -1)
                continue;
            res =  Math.min(res, ans+1 );
        }
        if(res == Integer.MAX_VALUE)
            return memo[amount] = -1;

        return memo[amount] = res;
    }

    public static void main(String[] args) {
        int[] coins = {2,5,10,1};
        int am = 27;
        CoinChange coinChange = new CoinChange();
        int res = coinChange.coinChange(coins,am);
        System.out.println(res);
    }

}
