package solutions.SortingAndSearchingAndSelctionProblems;

import java.util.HashSet;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0 )
            return 0;
        int n = nums.length;
        if(nums[0] > target)
            return 0;
        if(nums[n-1] < target)
            return n;

        int left = 0;
        int right = n-1;
        while(left <= right){
            int mid =  (right + left)/2;
            if(nums[mid] < target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return left;

    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        int target = 5;
        SearchInsert s = new SearchInsert();
        HashSet<Integer> hashSet;
        System.out.println(s.searchInsert(arr,target));
    }
}
