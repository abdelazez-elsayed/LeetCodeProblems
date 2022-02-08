package solutions;

import java.util.LinkedList;
import java.util.List;

public class findAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new LinkedList<>();
        if(p.length() > s.length())
            return ans;
        int n = s.length();
        int m = p.length();
        int[] freq = new int[26];
        int[] needed = new int[26];
        for(char c : p.toCharArray()){
            int i = c - 'a';
            freq[i]++;
            needed[i]++;
        }
        int total = m;
        for(int i=0; i<m;i++){
            int idx = s.charAt(i) - 'a';
            if(freq[idx]  > 0){
                needed[idx]--;
                if(needed[idx] >= 0)
                    total--;
            }
        }
        for(int i=0;i<n-m;i++){
            if(total==0)
                ans.add(i);
            int toRemove = s.charAt(i) - 'a';
            int toAdd = s.charAt(i+m) - 'a';
            if(freq[toRemove] > 0){
                needed[toRemove]++;
                if(needed[toRemove] <= freq[toRemove] && needed[toRemove] > 0){
                    total++;
                }
            }
            if(freq[toAdd] > 0){
                needed[toAdd]--;
                if(needed[toAdd] < freq[toAdd] && needed[toAdd] >= 0){
                    total--;
                }
            }
        }
        if(total==0)
            ans.add(n-m);
        return ans;
    }

    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        findAllAnagrams f = new findAllAnagrams();
        List<Integer> ans = f.findAnagrams(s,p);
        System.out.println(ans);
    }
}
