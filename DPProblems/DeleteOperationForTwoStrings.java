package solutions.DPProblems;

public class DeleteOperationForTwoStrings {
    int n,m;
    String word1,word2;
    Integer[][] memo;
    public int minDistance(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        n = word1.length();
        m = word2.length();
        memo = new Integer[n][m];
        return dp(0,0);
    }
    int dp(int i , int j){
        if(i == n)
            return m-j;
        if(j == m)
            return n-i;
        if(memo[i][j] != null)
            return memo[i][j];
        if(word1.charAt(i) == word2.charAt(j))
            return memo[i][j] = dp(i+1,j+1);
        memo[i][j] = Math.min(dp(i+1,j) , dp(i,j+1)) + 1;
        return memo[i][j];
    }

    public static void main(String[] args) {
        String s1 = "dinitrophenylhydrazine";
        String s2 = "acetylphenylhydrazine";
        DeleteOperationForTwoStrings d = new DeleteOperationForTwoStrings();
        System.out.println(d.minDistance(s1,s2));
    }
}
