package solutions;

public class ProblemProductOfArrayExceptSelfSolution {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length == 1)
            return new int[] {0};
        int n = nums.length;
        int[] ans = new int[n];
        ans[n-1] = 1;
        for(int i = n-2 ; i>=0; i--){
            ans[i] = ans[i+1]*nums[i+1];
        }
        int prefix = 1;
        for(int i=0; i<n;i++){
            ans[i] = prefix*ans[i];
            prefix *= nums[i];
        }
        return ans;
    }
}
