package solutions;

public class LongestPalindrome {
   int[][] dp;
    public String longestPalindrome(String s) {
        dp = new int[s.length()+1][s.length()+1];
        return longestPlaindromeSolver(s,0,s.length());

    }
    private String longestPlaindromeSolver(String s, int start , int end){

        int j=end-1;
        if(dp[start][end] == 1)
            return s.substring(start,end);
        else if(dp[start][end]==-1){
            return "";
        }
        if(start==end) {
            dp[start][end]=1;
            return String.valueOf(s.charAt(start));
        }
       for(int i=start; i<end;i++){
           if(s.charAt(i) == s.charAt(j)) {
               j--;
               if(i>=j) {
                   dp[start][end]=1;
                   return s.substring(start, end);
               }
           }else{
               dp[start][end]=-1;
               break;
           }
       }
        String s2 = longestPlaindromeSolver(s,start,end-1);
        String s1 = longestPlaindromeSolver(s,start+1,end);
       if(s1.length() > s2.length())return s1;
       else
           return s2;
    }
}
