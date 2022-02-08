package solutions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreak {
    int dp[][];
    Set<String> set;
    int n;
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        n = s.length();
        dp = new int[n+1][n+1];

        for(int i=0; i<n+1; i++){
            for(int j=0; j<n+1; j++){
                dp[i][j]=-1;
            }
        }
        dp_fun(s,0,n);
        if(dp[0][n] != 0)
            return true;
        return false;
    }
    int dp_fun(String s,int i,int j){
        if(i >= n || j >= n)
            return dp[i][j];
        if(dp[i][j] != -1)
            return dp[i][j];
        if(set.contains(s.substring(i,j))){
            return dp[i][j] =1;
        }else{
            return dp[i][j] = dp_fun(s,0,i)+dp_fun(s,i,n);
        }

    }

    public static void main(String[] args) {
        List<String> dic = new LinkedList<>();
        dic.add("leet");
        dic.add("code");
        String s = "leetsadcode";
        System.out.println(s.substring(0,4));
        System.out.println(s.substring(4));
        WordBreak wb = new WordBreak();
        boolean ans = wb.wordBreak(s,dic);
        System.out.println(ans);
    }
}
