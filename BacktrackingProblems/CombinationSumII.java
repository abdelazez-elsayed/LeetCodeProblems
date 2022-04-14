package solutions.BacktrackingProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    int n;
    int[] nums;
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        nums =arr;
        n = arr.length;
        List<Integer> list = new ArrayList<>();
        helper(0,target,list,res);
        return res;
    }
    void helper(int idx , int target, List<Integer> list , List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=idx; i < n; i++){
            if(target-nums[i] < 0)
                return;
            list.add(nums[i]);
            helper(i+1,target-nums[i],list,res);
            while(i+1 < n && nums[i+1] == nums[i])
                i++;
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        CombinationSumII c = new CombinationSumII();
        int[] arr = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> l = c.combinationSum2(arr,target);
        System.out.println(l);
    }
}
