package solutions.DPProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumXORSumOfTwoArrays {
    int n=0;
    Map<String,Integer> memo;
    public int minimumXORSum(int[] nums1, int[] nums2) {
        int[] mask = new int[nums1.length];
        memo = new HashMap<>();
        n = nums1.length;
        return dp(0,mask,nums1,nums2);
    }
    int dp(int i,int[] mask,int[] nums1,int[] nums2){
        if(i == n)
            return 0;
        String s = String.valueOf(i)+','+ Arrays.toString(mask);
        if(memo.containsKey(s))
            return memo.get(s);

        int result = Integer.MAX_VALUE;
        for(int j=0; j<nums1.length; j++){
            if(mask[j] == 1)
                continue;
            mask[j]=1;
            result = Math.min(result , (nums1[i] ^ nums2[j]) + dp(i+1,mask,nums1,nums2));
            mask[j]=0;
        }
        memo.put(String.valueOf(i)+','+ Arrays.toString(mask),result);
        return result;
    }

}
