package solutions.DPProblems;

public class InterleavingString {
    String s1,s2,s3;
    int n1,n2,n3;
    Boolean[][] memo;
    public boolean isInterleave(String s1, String s2, String s3) {
        this.s1=s1;
        this.s2=s2;
        this.s3=s3;
        n1 = s1.length();
        n2 = s2.length();
        n3 = s3.length();
        if(n1 + n2 != n3)
            return false;
        /**Top-down Recursive , O(N1*N2) Time , O(N1*N2) space **/
        /*
        memo = new Boolean[n1+1][n2+1];
        return solve(0,0);
        */


        //Bottom-Up , O(N1*N2) Time , O(N2) space
        boolean[] cur = new boolean[n2+1];
        boolean[] prv = new boolean[n2+1];
        for(int i=n1; i >= 0; i--){

            for(int j=n2; j>=0; j--){
                int k = i+j;
                if(j == n2 && i == n1){
                    cur[j] = true;
                    continue;
                }
                if(i == n1) {
                    cur[j] = s2.substring(j).equals(s3.substring(k));
                    continue;
                }
                if(j == n2) {
                    cur[j] = s1.substring(i).equals(s3.substring(k));
                    continue;
                }
                if(s1.charAt(i) == s3.charAt(k) && s2.charAt(j) == s3.charAt(k)){
                    cur[j] = cur[j+1] || prv[j];
                    continue;
                }
                if(s1.charAt(i) == s3.charAt(k)) {
                    cur[j] = prv[j];
                    continue;
                }
                if(s2.charAt(j) == s3.charAt(k)) {
                    cur[j] = cur[j+1];
                    continue;

                }
                cur[j] = false;
            }
            prv = cur;
            cur = new boolean[n2+1];
        }
        return prv[0];
    }
   boolean solve(int i, int j){
        if(memo[i][j] != null)
            return memo[i][j];
        int k= i+j;
        if(j == n2 && i == n1)
            return true;

        if(i == n1)
            return memo[i][j] = s2.substring(j).equals(s3.substring(k));

        if(j == n2)
            return memo[i][j] = s1.substring(i).equals(s3.substring(k));

        if(s1.charAt(i) == s3.charAt(k) && s2.charAt(j) == s3.charAt(k))
            return memo[i][j] = (solve(i+1,j) || solve(i,j+1));

        if(s1.charAt(i) == s3.charAt(k))
            return memo[i][j] = solve(i+1,j);

        if(s2.charAt(j) == s3.charAt(k))
            return memo[i][j] = solve(i,j+1);

        return memo[i][j] = false;

    }
}
