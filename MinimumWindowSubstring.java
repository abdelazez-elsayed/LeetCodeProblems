package solutions;

import java.util.HashMap;
import java.util.List;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(t.length() ==0 || t.length() > s.length())
            return "";
        if(s.length() == 1)
            return s.equals(t) ? s :"";
        boolean[] contains = new boolean[26*2];
        int[] freq = new int[26*2];
        for(char c : t.toCharArray()){
            contains[conv(c)] = true;
            freq[conv(c)] += 1;
        }

        int i=0;
        int j=0;
        int min= s.length()+1;
        String ans="";
        int t_cnt = t.length();
        while(i<=j && j< s.length()){
            char j_char;
            char i_char;
            while(j< s.length() && t_cnt > 0) {
                j_char = s.charAt(j++);
                if (contains[conv(j_char)]) {
                    freq[conv(j_char)] = freq[conv(j_char)] - 1;
                    if (freq[conv(j_char)] >= 0)
                        t_cnt--;
                }
            }
            while(i < s.length() && t_cnt == 0){
                i_char = s.charAt(i++);
                if(contains[conv(i_char)]) {
                    freq[conv(i_char)] = freq[conv(i_char)] + 1;
                    if (freq[conv(i_char)] > 0)
                        ++t_cnt;
                }
            }
            if(min > j-i+1){
                ans = s.substring(i-1,j);
                min = j-i+1;
            }
        }

        return ans;
    }
    int conv(char c){
        if(Character.isLowerCase(c))
            return c-'a';
        else
            return c - 'A' + 26;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        MinimumWindowSubstring m = new MinimumWindowSubstring();
        String ans = m.minWindow(s,t);
        System.out.println(ans);

    }
}
