package solutions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FindClosestElement {
    public int findClosestElement(int[] arr,  int x) {
        int n = arr.length;
        int left = 0, right = n - 1;
        int mid = n;
        int diff = Integer.MAX_VALUE;
        int ans = 0;

        if(n==1)
            return arr[0];
        while (left <= right) {
            mid = (left + right) / 2;
            int mid_diff = Math.abs(x - arr[mid]);
            if (mid_diff < diff) {
                diff = mid_diff;
                ans = arr[mid];
            }
            if (mid > 0) {
                int left_diff = Math.abs(x - arr[mid - 1]);
                if (left_diff <= diff) {
                    diff = left_diff;
                    ans = arr[mid-1];
                }
            }
            if (mid + 1 < n) {
                int right_diff = Math.abs(x - arr[mid + 1]);
                if (right_diff < diff) {
                    diff = right_diff;
                    ans = arr[mid+1];
                }
            }

            if (arr[mid] < x) {
                left = mid + 1;
            } else if ( arr[mid] > x){
                right = mid - 1;
            }else
                return x;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {-1,1,2,3,4,5};
        int target = -12;
        FindClosestElement f = new FindClosestElement();
        System.out.println(f.findClosestElement(arr,target));
    }
}
