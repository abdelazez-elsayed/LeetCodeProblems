package solutions;

import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
    int[] sol = new int[2];
    Arrays.sort(nums);
    int targetIdx;
    for(int i=0; i<nums.length;++i){
        targetIdx = binarySearch(nums,target-nums[i]);
        if(targetIdx != -1){
            sol[0]=i;
            sol[1]=targetIdx;
            return sol;
        }

    }
    return sol;
}
    private int binarySearch(int[] nums,int target){
        int low=0;
        int high=nums.length-1;
        int mid;
        while (low <= high){
            mid = (low+high)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid] > target){
                high = mid-1;
            }
            else
                low = mid+1;

        }
        return -1;
    }
}
