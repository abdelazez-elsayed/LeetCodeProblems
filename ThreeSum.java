package solutions;

import java.util.*;

public class ThreeSum {
    public ArrayList<List<Integer>> threeSum(int[] nums) {
        int N = nums.length;
        Set<List<Integer>> threeSums = new HashSet<>();
        if(N<3)return new ArrayList<>(threeSums);
        Arrays.sort(nums);
        for(int i=0; i<N-1; i++){
            int j=i+1;
            int k=N-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0){
                    List<Integer> threeSum = new LinkedList<>();
                    threeSum.add(nums[i]);
                    threeSum.add(nums[j++]);
                    threeSum.add(nums[k--]);
                    threeSums.add(threeSum);
                }
                else if(sum>0)
                    k--;
                else
                    j++;

            }
        }
        return new ArrayList<>(threeSums);
    }

    }


