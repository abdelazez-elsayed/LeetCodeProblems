package solutions.ArraysAndNumbersProblems;

import java.util.*;

public class CreateMaximumNumber {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        for(int i = 0; i<=k; i++){
            int j = k-i;
            if(i > nums1.length || j > nums2.length) continue;
            int[] max1 = highestK(nums1,i);
            int[] max2 = highestK(nums2,j);
            int[] m = greedly(max1,max2,0,0,k);
            res = maxArr(res,m);
        }
        return res;
    }

    public int[] highestK(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            while(!dq.isEmpty() && dq.getLast() < nums[i] && n-i+dq.size()-1 >= k)
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


    int[] maxArr(int[] a1,int[] a2){
        if(a1.length != a2.length)
            throw  new IllegalArgumentException("a1 l = "+a1.length+", a2.l = "+a2.length);
        for(int i=0;i<a1.length; i++){
            if(a1[i] > a2[i])
                return a1;
            else if(a2[i] > a1[i])
                return a2;
        }
        return a1;
    }

    int[] greedly(int[] a1,int[] a2,int i1,int i2,int k){
        int[] res = new int[k];
        int i=0;
        while(i1 < a1.length || i2 < a2.length){
           if(i1 >= a1.length) res[i++] = a2[i2++];
           else if( i2 >= a2.length)res[i++] = a1[i1++];
           else if(a1[i1] < a2[i2]) res[i++] = a2[i2++];
           else if(a1[i1] > a2[i2]) res[i++] = a1[i1++];
           else{
               if(greater(a1,a2,i1,i2))
                   res[i++] = a1[i1++];
               else
                   res[i++] = a2[i2++];
           }
        }
        return res;
    }

    private boolean greater(int[] a1, int[] a2, int i1, int i2) {
        while(i1 < a1.length || i2 < a2.length){
            if(i1 >= a1.length) return false;
            else if( i2 >= a2.length)return true;
            else if(a1[i1] < a2[i2]) return false;
            else if(a1[i1] > a2[i2]) return true;
            else{
               i1++;i2++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CreateMaximumNumber c = new CreateMaximumNumber();
        int k = 2;
        int[] nums1 = {8,1,8,8,6};
        int[] nums2 = {4};
        int[] res = c.maxNumber(nums1,nums2,k);
        System.out.println(Arrays.toString(res));
    }
}
