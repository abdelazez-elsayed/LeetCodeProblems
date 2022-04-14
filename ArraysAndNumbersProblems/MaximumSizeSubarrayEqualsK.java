package solutions.ArraysAndNumbersProblems;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarrayEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        // Write your code here
        int sum=0;
        int res=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; ++i){
            sum += nums[i];
            if(sum == k)
                res = Math.max(res,i+1);
            if(map.containsKey(sum - k))
                res = Math.max(res , i - map.get(sum-k));
            if(!map.containsKey(sum))
                map.put(sum,i);
        }
        return res;
    }
}
