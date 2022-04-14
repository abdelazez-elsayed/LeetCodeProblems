package solutions.StringsAndPatternsProblems;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int ans = 0;
        int cnt = 0;
        int start = 0;
        int n = s.length();
        for(int i=0;i<s.length(); i++){
            if(s.charAt(i) == '(')
                cnt++;
            else
                cnt--;
            if(cnt < 0){

                cnt = 0;
                start = i+1;
            }
            if(cnt == 0){
                ans = Math.max(ans, i-start+1);
            }
        }
        start = n-1;
        cnt = 0;
        for(int i=s.length()-1;i>= 0; i--){
            if(s.charAt(i) == ')')
                cnt++;
            else
                cnt--;
            if(cnt < 0){
                cnt = 0;
                start = i-1;
            }
            if(cnt == 0){
                ans = Math.max(ans, start-i+1);
            }
        }
        return ans;
    }
}
