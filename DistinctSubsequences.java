package solutions;

import java.util.Arrays;

public class DistinctSubsequences {
    String s,t;
    int n,m;
    int[][] dp;
    public int numDistinct(String s, String t) {
        this.s = s;
        this.t = t;
        n = s.length();
        m = t.length();
        dp = new int[n+1][m+1];
        for(int[] ar : dp)
            Arrays.fill(ar,-1);
        return solve(0,0);
    }
    int solve(int i , int j){
        if(dp[i][j] != -1)
            return dp[i][j];
        if(j == m)
            return 1;
        if(i >= n)
            return 0;
        if(s.charAt(i) == t.charAt(j))
            return dp[i][j] = solve(i+1,j+1)+solve(i+1,j);
        else
            return dp[i][j] = solve(i+1,j);
    }
}
