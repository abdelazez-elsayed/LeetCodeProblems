package solutions.DPProblems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreak {
    Boolean memo[][];
    Set<String> set;
    String s;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;
        set = new HashSet<>(wordDict);
        int n = s.length();
        memo = new Boolean[n+1][n+1];

        canBreak(0,n);
        return memo[0][n];
    }
    boolean canBreak(int i,int j){
        if(memo[i][j] != null)
            return memo[i][j];
        if(set.contains(s.substring(i,j))){
            return memo[i][j] = true;
        }else{
            for(int k = i; k<j; k++){
                if(set.contains(s.substring(i,k))){
                    boolean rResult = canBreak(k,j);
                    if(rResult)
                        return memo[i][j] = true;
                }
            }
            return memo[i][j] = false;
        }

    }

    public static void main(String[] args) {
        List<String> dic = new LinkedList<>();
        dic.add("leet");
        dic.add("code");
        String s = "leetcode";
        System.out.println(s.substring(0,4));
        System.out.println(s.substring(4));
        WordBreak wb = new WordBreak();
        boolean ans = wb.wordBreak(s,dic);
        System.out.println(ans);
    }
}
