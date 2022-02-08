package solutions;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySumEqualModK {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length <= 1)
            return false;
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        for(int i = 0; i< nums.length; i++){
            sum += nums[i];
            if(i!= 0 && sum % k == 0)
                return true;
            int r = sum % k ;
            if(map.containsKey(r)){
                if(i-map.get(r) > 1)
                    return true;
            }else{
                map.put(r,i);
            }
        }
        return false;
    }
}
