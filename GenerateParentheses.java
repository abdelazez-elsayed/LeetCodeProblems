package solutions;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        String s = "";
        gen(list,s,n,n,n);
        return filter(list);
    }
    private void gen(List<String> list,String s,int n_close,int n_open,int n){
        String close;
        String open;
        if(n_open !=0) {
            open = s + "(";
            gen(list,open,n_close,n_open-1,n);
            if(open.length() == n*2)
                list.add(open);
        }
        if(n_close != 0) {
            close = s + ")";
            gen(list,close,n_close-1,n_open,n);
            if(close.length()==n*2)
                list.add(close);
        }




    }
    private List<String> filter(List<String> list){
        List<String> validList = new ArrayList<String>();
        for(String s : list){
            if(validPren(s))
                validList.add(s);

        }
        return validList;
    }
    private boolean validPren(String s){
        int n=0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(')
                n++;
            else{
                n--;
                if(n<0)
                    return false;
            }

        }
        return n==0 ;
    }
}
