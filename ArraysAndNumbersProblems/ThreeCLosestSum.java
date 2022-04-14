package solutions.ArraysAndNumbersProblems;

import java.util.Arrays;

public class ThreeCLosestSum {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int result = nums[0]+nums[1]+nums[nums.length-1];
        for(int i=0;i<n-2;i++){
            int l = i+1;
            int r = n-1;
            while(l < r){
                int cur_sum = nums[i]+nums[l]+nums[r];
                if(cur_sum == target)
                    return cur_sum;
                if(cur_sum > target)
                    r--;
                else
                    l++;
                if(Math.abs(cur_sum-target) < Math.abs(result-target))
                    result = cur_sum;
            }
        }
        return result;
    }

}
