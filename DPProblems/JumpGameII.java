package solutions.DPProblems;

import java.util.Arrays;
import java.util.PriorityQueue;

public class JumpGameII {
    int[] memo;
    int n;
    int[] nums;
    public int jump(int[] nums) {
        this.nums = nums;
        n = nums.length;
        memo = new int[n];
        Arrays.fill(memo,-1);
        PriorityQueue<Integer> q= new PriorityQueue<>();
        return dp(0);
    }
    int dp(int i){

        if(memo[i] != -1)
            return memo[i];
        if(i >= n)
            return Integer.MAX_VALUE;
        if(i==n-1)
            return 0;
        int ans = Integer.MAX_VALUE;
        for(int j = 1; j <= nums[i]; j++){
            if(i+j > n-1)
                break;
            int pos =dp(j+i)+1;
            ans = Math.min(ans,pos);
        }
        return memo[i] = ans;
    }

    public static void main(String[] args) {
        JumpGameII j = new JumpGameII();
        int[] arr = {2,3,1,1,4};
        int ans = j.jump(arr);
        System.out.println(ans);
    }
}
