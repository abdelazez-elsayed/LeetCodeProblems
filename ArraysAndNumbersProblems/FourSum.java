package solutions.ArraysAndNumbersProblems;

import java.sql.Struct;
import java.util.*;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        Set<List<Integer>> forSums =  new HashSet<>();
        if(n<4)return new ArrayList<>(forSums);

        for(int i=0; i<n; i++){
            Set<List<Integer>> threeSums = threeSum(nums,target-nums[i],i);
            if(threeSums.size()>0){
                for(List<Integer> threeSum: threeSums ) {
                    threeSum.add(nums[i]);
                    forSums.add(threeSum);
                }
            }

        }
        return new ArrayList<>(forSums);
    }
    public Set<List<Integer>> threeSum(int[] nums,int target,int except) {
        int N = nums.length;
        Set<List<Integer>> threeSums = new HashSet<>();
        if(N<3)return threeSums;
        for(int i=0; i<N-1; i++){
            if(i==except)continue;
            int j=i+1;
            String s;
            int k=N-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==target){
                    List<Integer> threeSum = new LinkedList<>();
                    threeSum.add(nums[i]);
                    threeSum.add(nums[j++]);
                    threeSum.add(nums[k--]);
                    threeSums.add(threeSum);
                }
                else if(sum>target)
                    k--;
                else
                    j++;

            }
        }
        return threeSums;
    }
}
