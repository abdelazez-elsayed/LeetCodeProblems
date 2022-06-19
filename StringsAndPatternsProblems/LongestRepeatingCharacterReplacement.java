package solutions.StringsAndPatternsProblems;

import java.util.Arrays;

/*
Problem 424 leetcode
https://leetcode.com/problems/longest-repeating-character-replacement/

Sliding window
*/
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int i = 0 , n = s.length();
        int[] freq = new int[26];
        int ans = 0;
        for(int j=0; j<n; j++){
            char cj = s.charAt(j);
            int idxj = cj - 'A';
            freq[idxj]++;
            //if current window size has more characters except most frequencied character than k
            // --> shrink the window
            while(   (j-i+1) - max(freq)    >      k){
                char ci = s.charAt(i);
                int idxi = ci - 'A';
                freq[idxi]--;
                i++;
            }
            ans = Math.max(ans, j - i+1);
        }
        return ans;
    }
    int max (int[] arr){
        int r=0;
        for(int num :arr)
            r = Math.max(num,r);
        return r;
    }
}
