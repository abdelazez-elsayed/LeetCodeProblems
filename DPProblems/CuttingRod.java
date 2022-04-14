package solutions.DPProblems;

public class CuttingRod {
    int[] memo;
    int[] prices;
    public int cutting(int[] prices, int n) {
        // Write your code here
        this.prices = prices;
        memo = new int[n+1];
        return dp(n);
    }
    int dp(int n){
        if(n == 0)
            return 0;
        if(memo[n] != 0)
            return memo[n];
        int res = prices[n-1];
        for(int i=1; i< n; i++){
            res = Math.max(res,dp(n-i)+dp(i));
        }
        return memo[n] = res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 9, 10, 17, 17, 20};
        CuttingRod r = new CuttingRod();
        System.out.println(r.cutting(arr,arr.length));
    }
}
