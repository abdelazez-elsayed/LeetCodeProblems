package solutions;

import java.util.Stack;

public class BracketBalance {

    char get_matcher_closer(char c){
        if(c==']')
            return '[';
        if(c==')')
            return '(';
        if(c=='}')
            return '{';
        throw new IllegalArgumentException("Not a Bracket given");
    }
    boolean isBalanced(String s) {
        // Write your code here
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c=='[' )
                stack.push(c);
            else{
                char t = get_matcher_closer(c);
                try{
                    while(stack.peek() != t)
                        stack.pop();
                    stack.pop();
                }catch(Exception e){
                    return false;
                }

            }
        }
        return stack.isEmpty();
    }



    public static void main(String[] args) {

        float[] t = new float[2];
        System.out.println(t[0]);
    }


}
