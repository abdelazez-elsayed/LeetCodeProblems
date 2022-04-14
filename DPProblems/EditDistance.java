package solutions.DPProblems;

public class EditDistance {
    String word1,word2;
    int n1,n2;
    int[][] memo;
    public int minDistance(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        n1 = word1.length();
        n2 = word2.length();
        memo = new int[n1+1][n2+1];
        return dp(0,0);
    }
    int dp(int i, int j){
        if(i == n1)
            return n2-j;
        if(j == n2)
            return n1-i;
        if(memo[i][j] != 0)
            return memo[i][j];
        if(word1.charAt(i) == word2.charAt(j))
            return memo[i][j] = dp(i+1,j+1);
        else{
            //delete word1 char or insert word1 char at word2
            int del1 = 1+dp(i+1,j);
            //delete word2 char or insert word2 char at word1
            int del2 = 1+dp(i,j+1);
            //replace either word1 char with word2 char or vice versa
            int rep = 1+dp(i+1,j+1);
            int ans = Math.min(Math.min(del1,del2),rep);
            return memo[i][j] = ans;
        }
    }
}
