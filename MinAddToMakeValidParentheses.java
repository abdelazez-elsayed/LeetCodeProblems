package solutions;

import java.util.LinkedList;
import java.util.Queue;

public class MinAddToMakeValidParentheses {
    public int minAddToMakeValid2(String S) {
        int ans = 0, bal = 0;
        for (char c : S.toCharArray()) {
            bal += c == '(' ? 1 : -1;
            // It is guaranteed bal >= -1
            if (bal == -1) {
                ans++;
                bal++;
            }
        }

        return ans + bal;
    }
    public int minAddToMakeValid(String s) {
        int closeCount = 0;
        for(char c : s.toCharArray()){
            if( c == ')')
                closeCount++;
        }

        int ans=0, facedOpen = 0 , facedClose = 0;
        for(char c : s.toCharArray()){
            if( c == ')' && facedOpen <= facedClose){
                ans++;
                facedClose++;
                facedOpen++;
            }
            else if(c == '(' && (closeCount - facedClose) > 0  ){
                facedOpen++;
            }else if(c == ')' ){
                facedClose++;

            }else{
                facedOpen++;
                facedClose++;
                ans++;
            }

        }

        return ans+Math.abs(facedOpen - facedClose);
    }
}
