package solutions.DPProblems;

import java.util.*;

public class LongestStringChain_1048 {
    int n;
    HashMap<String, Integer> memo;
    Map<Integer, List<String>> orders;
    public int longestStrChain(String[] words) {
        this.n = words.length;
        memo = new HashMap<>();
        orders = new TreeMap<>();
        for(String word : words){
            int l = word.length();
            if(!orders.containsKey(l))
                orders.put(l , new ArrayList<>());
            List<String> list = orders.get(l);
            list.add(word);

        }
        int ans = 1;
        for(Integer order : orders.keySet()){
            for(String word : orders.get(order))
                ans = Math.max(ans, maxChain(word));
        }
        return ans;
    }
    int maxChain(String word){
        int nextOrder = word.length() + 1;
        if(!orders.containsKey(nextOrder))
            return 1;
        if(memo.containsKey(word))
            return memo.get(word);
        int ans = 1;
        for(String toChain : orders.get(nextOrder)){
            if(canChain(word,toChain))
                ans = Math.max(ans , maxChain(toChain)+1);
        }
        memo.put(word,ans);
        return ans;

    }
    boolean canChain(String w1 , String w2){
        if(w2.length() != w1.length()+1)
            return false;
        int cnt = 0 , j = 0 , i = 0;
        while(i<w1.length() && j < w2.length()){
            if(w1.charAt(i) == w2.charAt(j)){
                i++;
                j++;
            }else{
                cnt++;
                j++;
            }
        }
        return cnt <= 1;
    }
}
