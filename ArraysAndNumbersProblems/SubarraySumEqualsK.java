package solutions.ArraysAndNumbersProblems;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int ans=0;
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        int sum=0;
        for(int i=0; i<n; i++){
            sum+= nums[i];
            if(sum == k)
                ans++;

            if(map.containsKey(sum - k)) {
                ans += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK s = new SubarraySumEqualsK();
        int[] arr = {28,54,7,-70,22,65,-6};
        int k = 100;
        int res = s.subarraySum(arr,k);
        System.out.println(res);
    }
}
