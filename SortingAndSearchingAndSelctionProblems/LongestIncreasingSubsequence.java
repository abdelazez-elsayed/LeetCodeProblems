package solutions.SortingAndSearchingAndSelctionProblems;

import java.util.Arrays;
import java.util.regex.Matcher;

public class LongestIncreasingSubsequence {


    /**
     Patience Sort --> (N log(N) )
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 0)return 0;
        int[] dp = new int[n];
        int len = 0;
        for(int num : nums){
            int idx = Arrays.binarySearch(dp,0,len,num);
            if(idx < 0)
                idx = -(idx+1);
            dp[idx] = num;
            if(idx == len)
                len++;
        }
        return len;
    }
    /*
     DP --> O(N^2)
     */
    int[] memo;
    int n;
    int[] nums;
    public int DP(int[] nums){
        n = nums.length;
        this.nums = nums;
        if(n == 0)return 0;
        memo = new int[n];
        int res = 0;
        for(int i = 0; i<n; i++){
            int pos = dp(i);
            res = Math.max(pos , res) ;
        }
        return res;
    }

    private int dp(int i) {
        if(memo[i] != 0)
            return memo[i];
        int res = 1;
        for(int j=i+1; j<n;j++){
            if(nums[j] > nums[i])
                res = Math.max(res, dp(j)+1);

        }
        return memo[i] = res;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int[][] arrs = {{10,9,2,5,3,7,101,18},
                {0,1,0,3,2,3},
                {7,7,7,7,7,7,7},
                {4,10,4,3,8,9}
                        };
        int[] exp = {4,4,1,3};
        for(int i=0; i< arrs.length;  i++){
            int[] arr = arrs[i];
            int res = lis.DP(arr);
            if(res != exp[i])
                System.err.println("For arr = "+Arrays.toString(arr)+"\nExpected = "+exp[i]+", found = "+res);

        }
        int[] arr = {4,10,4,3,8,9};
        int ex = 3;
        int res = lis.DP(arr);
        System.err.println("For arr = "+Arrays.toString(arr)+"\nExpected = "+ex+", found = "+res);
    }
}
