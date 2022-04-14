package solutions.DPProblems;

public class KnightDialer {
    int[][] dp;
    int limit = 1000000007;     //0    1       2    3     4     5     6      7    8      9
    int[][] graph = new int[][]{{4,6},{6,8},{7,9},{4,8},{3,9,0},{},{1,7,0},{2,6},{1,3},{2,4}};
    public int knightDialer(int n) {
        dp = new int[10][n+1];
        int ans = 0;
        for(int i=0; i<10; i++){
            ans = (ans + find(i,n))%limit;
        }
        return ans;
    }
    int knightDialerMat(int n){
                        //0 1 2 3 4 5 6 7 8 9
            if(n == 1)
                return 10;
            long[][] M = {{0,0,0,0,1,0,1,0,0,0}, //0
                         {0,0,0,0,0,0,1,0,1,0},  //1
                         {0,0,0,0,0,0,0,1,0,1}, //2
                         {0,0,0,0,1,0,0,0,1,0}, //3
                         {1,0,0,1,0,0,0,0,0,1}, //4
                         {0,0,0,0,0,0,0,0,0,0}, //5
                         {1,1,0,0,0,0,0,1,0,0}, //6
                         {0,0,1,0,0,0,1,0,0,0}, //7
                         {0,1,0,1,0,0,0,0,0,0}, //8
                         {0,0,1,0,1,0,0,0,0,0}}; //9
            long[][] tot = new long[10][10];
            tot = pow(M,n-1,tot);
            return (int)sum(tot)%limit;
    }

    private long sum(long[][] tot) {
        long ans = 0;
        for(long[] arr : tot){
            for(long num : arr)
                ans = (ans + num)%limit;
        }
        return ans%limit;
    }

    long[][] mul(long[][] a , long[][] b){
        long[][] res = new long[a.length][b.length];
        for(int i=0;i<a.length;i++){
            for(int j=0; j<b.length;j++){
                for(int k=0;k<a.length;k++){
                    res[i][j] = (res[i][j] + a[i][k] * b[k][j])%limit;
                }
            }
        }
        return res;
    }
    void one(long[][] res){
        for (int i = 0; i < res.length; i++)
            res[i][i] =1;
    }
    long[][] pow(long[][] a, long n, long[][] res)
    {
        one(res);

        while (n > 0) {
            if (n % 2 == 0)
            {
                a = mul(a, a);
                n /= 2;
            }
            else {
                res = mul(res, a);
                n--;
            }
        }
        return res;
    }
    int find(int digit, int n){
        if(dp[digit][n] != 0)
            return dp[digit][n];
        if(n == 1)
            return dp[digit][1] = 1;
        int ans = 0 ;
        for(int nei : graph[digit]){
            ans = (ans + find(nei,n-1))%limit;
        }
        return dp[digit][n] = ans;

    }

    public static void main(String[] args) {
        int cnt = 0;
        for(int i=10; i<=99; i++){
            cnt++;
        }
        System.out.println(cnt);
    }
}
