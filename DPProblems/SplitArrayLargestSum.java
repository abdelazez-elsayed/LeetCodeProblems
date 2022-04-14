package solutions.DPProblems;

public class SplitArrayLargestSum {
    Integer[][] memo;
    int n;
    int[] nums;
    int[] sufSum;
    int[] maxElem;

    public int splitArray(int[] nums, int m) {
        n = nums.length;
        this.nums = nums;
        maxElem = new int[n];
        sufSum = new int[n];
        sufSum[n-1] = nums[n-1];
        maxElem[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--){
            sufSum[i] = nums[i] + sufSum[i+1];
            maxElem[i] =  Math.max(nums[i],maxElem[i+1]);
        }
        //DP solution --> O(N^2 * M)*******
        /*
        memo = new Integer[n+1][m+1];
        return dp(0,m);
        //********************
         */
        //BinarySearch Solution O(N * Log(S) ) ( S is sum of elements in nums)
        int left = maxElem[0];
        int right = sufSum[0];
        int ans = -1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(canSplit(mid,m)){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }

    private boolean canSplit(int sum,int m) {
        int cur = 0;
        for(int num : nums){
            cur += num;
            if(cur > sum){
                m--;
                cur = num;
                if(m<1)return false;
            }
        }
        return true;
    }

    int dp(int i,int m){
        if(memo[i][m] != null)
            return memo[i][m];
        if(n-i == m)
            return memo[i][m] = maxElem[i];
        if(m == 1){
            return sufSum[i];
        }
        int ans = Integer.MAX_VALUE;
        int prf = 0;
        for(int j=i;j<= n-m; j++){
            prf += nums[j];
            int split = dp(j+1,m-1);
            ans = Math.min(ans,Math.max(prf,split));
        }
        return memo[i][m] = ans;
    }

    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int m = 2;
        SplitArrayLargestSum sp  = new SplitArrayLargestSum();
        int ans =  sp.splitArray(nums,m);
        System.out.println(ans);
        System.out.println(sp.canSplit(14,m));
    }
}
