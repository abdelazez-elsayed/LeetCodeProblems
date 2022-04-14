package solutions.SortingAndSearchingAndSelctionProblems;

public class FirstAndLastOccuranceInSortedArray {
    private int find_first(int[] nums, int x){
        int left =0;
        int right = nums.length-1;
        int ans= nums.length;
        while(left <= right){
            int m = left + (right-left)/2;
            if(nums[m] >= x){
                right = m-1;
                ans = m;
            }
            else
                left = m+1;
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0)return new int[] {-1,-1};
        int first = find_first(nums,target);
        if(first >= nums.length || nums[first] != target ){
            return new int[] {-1,-1};
        }
        int second = find_first(nums,target+1)-1;
        return new int[] {first,second};

    }
}
