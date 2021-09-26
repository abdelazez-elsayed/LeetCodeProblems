package solutions;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '[' || c =='{' || c=='(')
                stack.push(c);
            else {
                if(stack.empty())
                    return false;
                char t = stack.peek();
                if((c == ')' && t == '(') || (t == '[' && c==']') || ( t =='{' && c=='}') )
                    stack.pop();
                else return false;
            }
        }
        return stack.empty();
    }
}
