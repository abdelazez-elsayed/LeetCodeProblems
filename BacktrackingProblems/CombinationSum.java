package solutions.BacktrackingProblems;

import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> l = new LinkedList<>();
        helper(ans,l,0,candidates,target);
        return ans;
    }
    void helper(List<List<Integer>> ans,List<Integer> to_fill , int i , int[] candidates,int target){

        if(target < 0)
            return;
        if(target == 0){
            ans.add(new LinkedList<>(to_fill));
        }
        for(int j = i ; j<candidates.length;j++){
            to_fill.add(candidates[j]);
            helper(ans,to_fill,j,candidates,target-candidates[j]);
            to_fill.remove(to_fill.size()-1);
        }

    }

    public static void main(String[] args) {
        CombinationSum c = new CombinationSum();
        int[] arr = {2,3,5};
        int t = 8;
        List<Integer> l;

        for(List<Integer> l1 : c.combinationSum(arr,t)){
            System.out.println(l1);
        }
    }
}
