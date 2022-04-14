package solutions;

import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i < n; ){
            if(!stack.isEmpty() && stack.peek() > num.charAt(i) && k > 0){
                stack.pop();
                k--;
            }
            else
                stack.push(num.charAt(i++));
        }
        for(Character c : stack){
            sb.append(c);
        }
        int i = 0;
        while(i<sb.length() && sb.charAt(i) == '0')i++;
        StringBuilder sb2 = new StringBuilder();
        for(; i < sb.length()-k; i++)
            sb2.append(sb.charAt(i));
        String res = sb2.toString();
        if(res.equals(""))
            return "0";
        return res;
    }
}
