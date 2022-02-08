package solutions;

import java.util.Stack;

public class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        int i = 1;
        Stack<Integer> stack;
        char[] c = new char[4];
        String  s = new String(c);
        for(int num  : arr){
            if(num != i){
                k -= (num - i);
                if(k <= 0)
                    return num - 1 + k ;
                i = num+1;
            }else
                i++;

        }
        return i + k -1;

    }
}
