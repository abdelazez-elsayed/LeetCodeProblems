package solutions.DPProblems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UncrossedLines {
    Map<Integer, List<Integer>> map;
    int n1,n2;
    int[] nums1;
    int[] nums2;
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        map = new HashMap<>();
        n1 = nums1.length;
        n2 = nums2.length;
        this.nums1 = nums1;
        this.nums2 = nums2;
        for(int i=0; i<nums2.length;i++){
            if(map.containsKey(nums2[i])){
                map.get(nums2[i]).add(i);
            }else{
                map.put(nums2[i],new LinkedList<>());
                map.get(nums2[i]).add(i);
            }
        }
        return dp(0,-1);
    }
    int dp(int start, int min){
        if(start == n1)
            return 0;
        int ans = 0;
        if(map.containsKey(nums1[start])){
            for(int adj : map.get(nums1[start])){
                if(adj > min){
                    ans = Math.max(ans,1+ dp(start+1,adj));
                }
            }
            return ans;
        }else{
            return dp(start+1,min);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,4,2};
        int[] nums2 = {1,2,4};
        UncrossedLines u = new UncrossedLines();
        int ans = u.maxUncrossedLines(nums1,nums2);
        System.out.println(ans);
    }
}
