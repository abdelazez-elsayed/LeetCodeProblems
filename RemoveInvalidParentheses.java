package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses {
    List<String> ans;
    Set<String> set = new HashSet<>();
    String s;
    int n;
    public List<String> removeInvalidParentheses(String s) {
        this.s=s;
        n = s.length();
        int l=0,r=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(')
                l++;
            else if(s.charAt(i) == ')'){
                if(l > 0)
                    l--;
                else
                    r++;
            }
        }
        System.out.println("L= "+l+", R = " + r);
        StringBuilder sb = new StringBuilder(s);
        backtracking(0,l,r,sb);
        ans = new ArrayList<>(set);
        return ans;
    }
    void backtracking(int idx ,int l,int r,StringBuilder sb){
        if(l == 0 && r == 0){
            if(check(sb.toString()))
                set.add(sb.toString());
        }
        for(int i=idx; i< sb.length(); i++){
            if(sb.charAt(i) == '(' &&  l > 0){
                sb.deleteCharAt(i);
                backtracking(i,l-1,r,sb);
                sb.insert(i,'(');
            }else if(sb.charAt(i) == ')' && r > 0){
                sb.deleteCharAt(i);
                backtracking(i,l,r-1,sb);
                sb.insert(i,')');
            }
        }
    }
    boolean check(String s){
        int l=0;
        for(int i = 0 ; i<s.length(); i++){
            if(s.charAt(i) == '(')
                l++;
            else if(s.charAt(i) == ')'){
                if( l == 0)return false;
                l--;
            }
        }
        return l == 0;
    }

    public static void main(String[] args) {
        String s=  ")(f";
        RemoveInvalidParentheses r = new RemoveInvalidParentheses();
        List<String> l = r.removeInvalidParentheses(s);

    }
}
