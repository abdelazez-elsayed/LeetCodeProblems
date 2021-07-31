package solutions;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int N = nums.length;
        List<Integer> twoSum = new LinkedList<>();
        List<List<Integer>> threeSum = new LinkedList<>();
        for (int i=0; i<N; i++){
            for(int j=i+1;j<N;j++){
                if(nums[i] != nums[j])
                    twoSum.add(nums[i]+nums[j]);
            }
        }
        for(int i=0; i<N; i++ ){
            for(Integer integer : twoSum){
                if(nums[i]+integer == 0){

                }



            }
        }
        return  threeSum;
    }
}
