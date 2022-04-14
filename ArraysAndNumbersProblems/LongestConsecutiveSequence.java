package solutions.ArraysAndNumbersProblems;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num  : nums){
            set.add(num);
        }
        int ans =0;
        for(int num : nums){
            if(!set.contains(num-1)){
                int cnt =1;
                int next = num+1;
                while(set.contains(next++))
                    cnt++;
                ans = Math.max(ans,cnt);
            }
        }
        return ans;
    }
}
