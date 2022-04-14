package solutions.StringsAndPatternsProblems;

import java.util.Arrays;
import java.util.Stack;
public class RemoveAllAdjacentDuplicatesInStringII {
    class Node{
        char c;
        int cnt;
        Node(char _c , int _cnt){
            c = _c;
            cnt = _cnt;
        }
    }
    public String removeDuplicates(String s, int k) {
        if(s.length() <= 1 || k == 1)
            return s;
        int n = s.length();
        Stack<Node> stack = new Stack<>();
        char[] arr = s.toCharArray();
        stack.push(new Node(arr[0],1));
        for(int i = 1 ; i<n; i++ ){
            if(!stack.isEmpty() && stack.peek().c == arr[i]){
                if(stack.peek().cnt == k-1){
                    for(int j=0; j<k-1; j++)
                        stack.pop();
                }else{
                    stack.push(new Node(arr[i] , stack.peek().cnt + 1));
                }
            }else{
                stack.push(new Node(arr[i],1));
            }
        }
        char[] res = new char[stack.size()];
        int size = stack.size();
        int i = 0;
        while(!stack.isEmpty()){
            res[size-1-i] = stack.pop().c;
            i++;
        }
        return new String(res);

    }

    public static void main(String[] args) {
        String s = "deeedbbcccbdaa";
        int k = 3;
        RemoveAllAdjacentDuplicatesInStringII r = new RemoveAllAdjacentDuplicatesInStringII();
        //System.out.println(r.removeDuplicates(s,k));
        int[] arr = {23, 33, 14, 15, 42, 28, 33, 45, 23, 34, 39, 21, 36, 23, 34, 36, 25, 9, 11, 19, 35, 24, 31, 29,
                16, 23, 34, 24, 38, 15, 13, 35, 28};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr)+",N = "+arr.length);
        double sum = Arrays.stream(arr).reduce(Integer::sum).getAsInt();
        System.out.println(sum/arr.length);
    }
}
