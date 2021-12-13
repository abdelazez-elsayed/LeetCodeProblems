package solutions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AllPossibleSubsetsWithDuplicates {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<Integer> nully = new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);
        solv(ans,nully,nums,0);
        return ans;
    }
    private void solv(List<List<Integer>> ans, List<Integer> prev, int[] nums, int idx){
        ans.add(new LinkedList<>(prev));

        for(int i=idx; i<nums.length; i++){
            int num = nums[i];
            prev.add(num);
            solv(ans,prev,nums,i+1);
            prev.remove(prev.size()-1);
            while(i + 1 < nums.length && nums[i] == nums[i+1]) {
                i++;
            }

        }
    }
}
