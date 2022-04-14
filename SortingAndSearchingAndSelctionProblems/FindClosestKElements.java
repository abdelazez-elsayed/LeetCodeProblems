package solutions.SortingAndSearchingAndSelctionProblems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FindClosestKElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int left = 0 , right = n-1;
        int idx = n;
        if(n == k) return Arrays.stream(arr).boxed().collect(Collectors.toCollection(LinkedList::new));
        int mid = n;
        LinkedList<Integer> ans = new LinkedList<>();
        int diff = Integer.MAX_VALUE;
        while(left <= right){
            mid = (left+right)/2;
            if(mid - 1 >= 0 ){
                int left_diff = Math.abs(x-arr[mid-1]);
                if(left_diff <= diff){
                    diff = left_diff;
                    idx = mid-1;
                }
            }
            if(mid + 1 < n){
                int right_diff = Math.abs(x-arr[mid+1]);
                if(right_diff < diff){
                    diff = right_diff;
                    idx = mid+1;
                }
            }
            if(arr[mid] == x){
                idx = mid;
                break;
            }else if(arr[mid] <x){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        if(idx == n){
            for(int i=0;i<k;i++)
                ans.addFirst(arr[n-1-i]);
            return ans;
        }
        if(right == -1){
            for(int i=0;i<k;i++)
                ans.add(arr[i]);
            return ans;
        }
        int l=idx-1,r=idx+1;
        ans.add(arr[idx]);
        for(int i=0 ; i<k-1; i++){
            if(l >= 0){
                if(r < n){
                    if(Math.abs(x-arr[l]) <= Math.abs(x-arr[r])){
                        ans.addFirst(arr[l--]);
                    }else{
                        ans.addLast(arr[r++]);
                    }
                }else{
                    ans.addFirst(arr[l--]);
                }
            }else{
                ans.addLast(arr[r++]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,3};
        int k = 1;
        int x = 2;
        FindClosestKElements f = new FindClosestKElements();
        System.out.println(f.findClosestElements(arr,k,x));
    }
}
