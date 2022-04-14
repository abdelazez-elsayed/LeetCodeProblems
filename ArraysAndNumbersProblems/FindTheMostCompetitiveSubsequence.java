package solutions.ArraysAndNumbersProblems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class FindTheMostCompetitiveSubsequence {
    public int[] mostCompetitive(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            while(!dq.isEmpty() && dq.getLast() > nums[i] && n-i+dq.size()-1 >= k)
                dq.removeLast();
            if(dq.size() < k)
                dq.addLast(nums[i]);
        }
        int[] res = new int[k];
        int i=0;
        for(int num : dq)
            res[i++] = num;
        return  res;
    }

    public static void main(String[] args) {
        FindTheMostCompetitiveSubsequence f = new FindTheMostCompetitiveSubsequence();
        int k = 4;
        int[] arr = {2,4,3,3,5,4,9,6};
        int[] res= f.mostCompetitive(arr,k);
        System.out.println(Arrays.toString(res));
    }
}
