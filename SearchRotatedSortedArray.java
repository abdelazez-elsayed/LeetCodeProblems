package solutions;

import java.util.Arrays;

public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length==0)
            return -1;

        int n = nums.length;
        if(nums[0] < nums[n-1]) return Arrays.binarySearch(nums,target);
        int left=0;
        int right=n-1;
        int maxI;
        while(right > left){
            int mid = (right+left)/2;
            if(nums[mid] > nums[right])
                left = mid+1;
            else
                right=mid;
        }
        int start = left;
        left = 0;
        right =n-1;
        if(target >= nums[start] && target <= nums[right]) {
            left = start;
        }
        else{
            right = start;
        }
        //Using Java Util
        /*
        int ans = Arrays.binarySearch(nums,left,right+1,target);
        return ans >= 0 ? ans : -1;
        */
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid] > target)
                right = mid -1;
            else
                left = mid +1 ;
        }
        return -1;
    }

    public static void main(String[] args) {


    }
    public static int strStr(String haystack, String needle) {
        if(needle.length()==0)
            return 0;

        for(int i=0; i<haystack.length(); i++){
            int j=0;
            int k=i;
            while(haystack.charAt(k) == needle.charAt(j)){
                char c1 = haystack.charAt(i);
                char c2 = needle.charAt(j);
                k++;
                j++;
                if(j==needle.length())return i;
                if(i==haystack.length())return -1;

            }
            if(k>i)
                i=k-1;
        }
        return -1;
    }

}