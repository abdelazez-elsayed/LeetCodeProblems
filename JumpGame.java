package solutions;

public class JumpGame {
    int[] dp;
    int n;
    // O(N)
    public boolean canJumpGreedy(int[] nums){
        n = nums.length;
        int goalPost = n-1;
        for(int i=n-1; i>=0; --i){
            if(nums[i] + i >= goalPost)
                goalPost = i;
        }
        return goalPost == 0 ;
    }
    //O(N^2)
    public boolean canJumpDp(int[] nums) {
        if(nums.length == 1 )
            return true;
        n = nums.length;
        dp = new int[n+1];
        solv(0,nums);
        return dp[0] == 1;
    }
    int solv(int i,int[] nums){
        if(i>= n)
            return -1;
        if(i==n-1)
            return 1;
        if(dp[i] != 0)
            return dp[i];
        for(int j=1; j<= nums[i]; j++ ){
            int ans = solv(i+j,nums);
            if(ans==1)
                return dp[i] = 1;
        }
        return dp[i] = -1;
    }
}
