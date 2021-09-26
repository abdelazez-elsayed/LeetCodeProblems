package solutions;

import java.util.HashSet;

public class ThreeCLosestSum {
    HashSet<Integer> hs;
    public int threeSumClosest(int[] nums, int target) {
        hs = new HashSet<>();
        int margin=0;
        int targetWithMargin = target;
        int N= nums.length;
        putAllinHashSet(hs,nums);
        while(true){
            targetWithMargin = target + margin;
            for(int i=0; i < N;i++ ){
                int[] twoSums = twoSum(nums,targetWithMargin-nums[i],i);
                if(twoSums[0] != -1 && twoSums[1] != -1){
                    return targetWithMargin;
                }
            }
            targetWithMargin = target - margin;
            for(int i=0; i < N;i++ ){
                int[] twoSums = twoSum(nums,targetWithMargin-nums[i],i);
                if(twoSums[0] != -1 && twoSums[1] != -1){
                    return targetWithMargin;
                }
            }
            margin++;
        }
    }
    private  void putAllinHashSet(HashSet<Integer> hs , int[] nums){
        for(int i : nums)
            hs.add(i);
    }
    public int[] twoSum(int[] nums, int target,int except) {
        int[] arr = new int[2];
        arr[0]= arr[1] = -1;

        for(int i=0; i<nums.length; i++){
            if(hs.contains(target-nums[i] ) && i != except){
                arr[1] = i;
                break;
            }
        }
        if(arr[1] == -1)return arr;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == target - nums[arr[1]] && arr[1] != i && i != except)
                arr[0] = i;
        }
        return arr;
    }
}
