package solutions;

import java.util.HashSet;

public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        //memo = new int[nums.length+1][nums.length+2];
        HashSet<Integer>[] sets = new HashSet[nums.length];
        for(int i=0; i<nums.length;i++){
            int idx=nums[i];
            while (!sets[i].contains(idx)){
                sets[i].add(idx);
                idx = nums[idx];
            }
        }
        int ans=0;
        for (HashSet<Integer> set : sets) {
            if (set.size() > ans)
                ans = set.size();
        }
        return ans;

    }
}
