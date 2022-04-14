package solutions;

public class UniqueBinarySearchTrees {
    int[] memo;
    public int numTrees(int n) {
        memo = new int[n+1];
        return dp(n);
    }
    int dp(int n){
        if (n == 0 || n==1)
            return 1;
        if(memo[n] != 0)
            return memo[n];

        int res = 0;
        for(int i=0; i < n; i++){
            res += (dp(i) * dp(n-i-1));
        }
        return memo[n] = res;
    }
}
