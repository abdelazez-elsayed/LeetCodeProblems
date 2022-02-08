package solutions;

import java.util.LinkedList;
import java.util.List;

public class Permutations {
    boolean[] picked;
    int[] nums;
    int n;
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums ;
        n = nums.length;
        picked = new boolean[n];
        ans = new LinkedList<>();
        LinkedList<Integer> init = new LinkedList<>();
        solv(0,init);
        return ans;
    }
    void solv(int i,LinkedList<Integer> init){
        if( i == n){
            ans.add(new LinkedList<>(init));
            return;
        }
        for(int j = 0 ; j<n; j++){
            if(!picked[j]){
                picked[j] = true;
                init.add(nums[j]);
                solv(i+1,init);
                picked[j] = false;
                init.removeLast();
            }
        }
    }
}
