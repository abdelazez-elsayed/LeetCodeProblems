package solutions;

public class NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] cnt = new int[n];
        int max = 1;
        for(int i = n-1; i>=0; --i){
            ans[i] = 1;
            cnt[i] = 1;
            for(int j=i+1; j<n; j++){
                if(nums[j] > nums[i]){
                    if(ans[i] == 1+ans[j])
                        cnt[i] += cnt[j];
                    else if(ans[i] < 1+ans[j]){
                        cnt[i] = cnt[j];
                        ans[i] = 1+ans[j];
                    }
                    if(ans[i] > max){
                        max = ans[i];
                    }
                }
            }
        }
        int res=0;
        for(int i=0; i<n; i++){
            if(ans[i]==max)
                res += cnt[i];
        }
        return res;
    }
}
