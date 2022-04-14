package solutions.BacktrackingProblems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AllPossibleSubsets {
    public List<List<Integer>> subsets(int[] nums) {
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
        }
    }
    public List<List<Integer>> subsetsIterative(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new LinkedList<>();
        int pow = 1 << n;
        for(int i=0; i< pow; i++){
            List<Integer> sub = new LinkedList<>();
            for(int j=1; j<=n; j++){
                if( (i & (1 << (j-1))) > 0)
                    sub.add(nums[j-1]);
            }
            ans.add(sub);
        }
        return ans;
    }


}
