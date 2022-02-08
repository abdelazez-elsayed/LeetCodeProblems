package solutions;

import java.util.Stack;

public class BasicCalculator {
    /*

     */
    class Pair{
        int num;int idx;
        Pair(int num,int idx){
            this.num = num;
            this.idx = idx;
        }
    }
    int n;
    public int calculate(String s) {
        n = s.length();
        return calc(0,s).num;
    }

    private Pair calc(int it,String s) {
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        char op = '+';
        while (it < n){
            char c = s.charAt(it);
            if(Character.isDigit(s.charAt(it)))
                num = num * 10 + s.charAt(it) -'0';
            else if(c == '+' || c == '-' || c=='*' || c == '/') {
                update(op, num, stack);
                num = 0;
                op = c;
            }else if( c == '('){
                Pair p = calc(it+1,s);
                num = p.num;
                it = p.idx ;
            }else if( c == ')'){
                update(op,num,stack);
                return new Pair(sum(stack),it);
            }
            it++;
        }
        update(op,num,stack);
        return new Pair(sum(stack),0);
    }
    int sum(Stack<Integer> stack){
        int sum = 0;
        for(int i : stack)
            sum += i;
        return sum;
    }

    void update(char op , int val,Stack<Integer> stack){
        if(op == '+') stack.push(val);
        if(op == '-') stack.push(-val);
        if(op == '*') stack.push(stack.pop() * val);
        if(op == '/') stack.push(stack.pop() / val);
    }

    public static void main(String[] args) {
        String exp = " -(3 - (- (4 + 5) ) )";
        BasicCalculator b = new BasicCalculator();
        System.out.println(b.calculate(exp));
    }
}
