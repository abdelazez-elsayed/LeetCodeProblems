package solutions.ArraysAndNumbersProblems;

import java.util.ArrayList;

public class LongestOnes {
    public int longestOnes(int[] nums, int k) {
        int zeroCount=0, left=0, res=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right] == 0) zeroCount++;
            while(zeroCount > k){
                if(nums[left] == 0) zeroCount--;
                left++;
            }
            res=Math.max(res,right-left+1);
        }
        ArrayList<Integer> list;
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k  = 3;
        LongestOnes l = new LongestOnes();
        int ans = l.longestOnes(arr,k);
        System.out.println(l.longestOnes(arr,k));
    }
}
