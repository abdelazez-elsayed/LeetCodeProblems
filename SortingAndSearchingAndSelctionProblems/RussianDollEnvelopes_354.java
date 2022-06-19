package solutions.SortingAndSearchingAndSelctionProblems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Based On patience Sort ,
 * Sort envelopes by (width asec, if equal widths -> height desc) or vice versa
 * then find longest strictaly increasing subsequence (Problem 300) of height
 */
public class RussianDollEnvelopes_354 {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0
                || envelopes[0] == null || envelopes[0].length != 2)
            return 0;
        Arrays.sort(envelopes, (arr1, arr2) -> {
            if(arr1[0] == arr2[0])
                return arr2[1] - arr1[1];
            else
                return arr1[0] - arr2[0];
        });
        int n = envelopes.length;
        int[] dp = new int[n];
        int len = 0;
        for(int[] e : envelopes){
            int idx = binarySearch(dp,0,len,e);
            if(idx < 0)
                idx = -(idx+1);
            dp[idx] = e[1];
            if(idx == len)
                len++;
        }
        return len;
    }
    int binarySearch(int[] nums, int start, int end, int[] x){
        int res = end;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] >= x[1]){
                end = mid-1;
                res = mid;
            }
            else{
                start = mid+1;
            }
        }
        return res;
    }

}
