package solutions.SortingAndSearchingAndSelctionProblems;

import java.util.ArrayList;

public class GuessNumberHigherOrLowerII {
    int[][] memo;
    public int getMoneyAmount(int n) {
        memo = new int[n+1][n+1];
        ArrayList<Integer> l = new ArrayList<>(10);
        return solve(1,n);
    }
    int solve(int low , int high){
        if(low >= high)
            return 0;
        if(memo[low][high] != 0 )
            return memo[low][high];
        int ans = Integer.MAX_VALUE;
        for(int guess=low; guess <= high; guess++){
            int left = solve(low,guess-1);
            int right = solve(guess+1,high);
            int worst_decision = Math.max(left,right);
            ans = Math.min(ans, guess +  worst_decision );
        }
        return memo[low][high] = ans;
    }

    public static void main(String[] args) {
        GuessNumberHigherOrLowerII g= new GuessNumberHigherOrLowerII();
        int ans = g.getMoneyAmount(10);
        System.out.println(ans);
    }
}
