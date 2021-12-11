package solutions;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];

        HashSet<Integer> hs = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            if(hs.contains(target-nums[i])){
                arr[1] = i;
                break;
            }
            hs.add(nums[i]);
        }

        for(int i=0; i<nums.length; i++){
            if(nums[i] == target - nums[arr[1]] && arr[1] != i)
                arr[0] = i;
        }
        return arr;
    }
}
