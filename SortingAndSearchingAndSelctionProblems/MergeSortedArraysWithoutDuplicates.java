package solutions.SortingAndSearchingAndSelctionProblems;

import java.util.ArrayList;

public class MergeSortedArraysWithoutDuplicates {
    Integer[] mergeTwo(int[] a, int[] b){
        int n=a.length;
        int m=b.length;
        int i=0,j=0,k=0;
        ArrayList<Integer> ans = new ArrayList<>();
        while (i < n && j < m){
            if(a[i] < b[j]){
                if(k > 0 && ans.get(k-1) == a[i]){
                    i++;
                }else{
                    ans.add(a[i]);
                    k++;
                    i++;
                }
            }else{
                if(k>0 && ans.get(k-1) == b[j]) {
                    j++;
                }else {
                    ans.add(b[j]);
                    k++;
                    j++;
                }
            }
        }
        while(i < n){
            if(k > 0 && ans.get(k-1) == a[i]){
                i++;
            }else{
                ans.add(a[i]);
                k++;
                i++;
            }
        }
        while (j < m){
            if(k>0 && ans.get(k-1) == b[j]) {
                j++;
            }else {
                ans.add(b[j]);
                k++;
                j++;
            }
        }
        return ans.toArray(new Integer[0]);
    }

    public static void main(String[] args) {
        MergeSortedArraysWithoutDuplicates m = new MergeSortedArraysWithoutDuplicates();
        int[] a = {0,0,1,2,3,7};
        int[] b = {1,2,2,4,5};
        Integer[] ans = m.mergeTwo(a,b);
        for(Integer i : ans){
            System.out.print(i+", ");
        }
    }

}
