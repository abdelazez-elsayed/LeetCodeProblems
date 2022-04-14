package solutions.ArraysAndNumbersProblems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SplitArrayWithEqualSum {
    public boolean splitArray(List<Integer> nums) {
        // write your code here
        int n = nums.size();
        int[] prefixSum = new int[n];
        int q = 0;
        for(Integer num : nums){
            if(q==0) prefixSum[q] = num;
            else prefixSum[q] = prefixSum[q-1] + num;
            q++;
        }
        for(int j=3 ; j < n-3; j++){
            Set<Integer> set = new HashSet<>();
            for(int i=1 ; i < j - 1; i++){
                int sum1 = prefixSum[i-1];
                int sum2 = prefixSum[j-1] - prefixSum[i];
                if(sum1 == sum2)
                    set.add(sum1);
            }
            for(int k = j + 1; k<n-1 ; k++){
                int sum1 = prefixSum[k-1] - prefixSum[j];
                int sum2 = prefixSum[n-1] - prefixSum[k];
                if(sum1 == sum2 && set.contains(sum1))
                    return true;
            }
        }
        return false;
    }

}
