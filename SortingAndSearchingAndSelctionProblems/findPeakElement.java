package solutions.SortingAndSearchingAndSelctionProblems;

public class findPeakElement {
    public int findPeakElement(int[] nums) {
        int l = 0, n = nums.length, r = n-1;
        int mid;
        if(n==1)
            return 0;
        while(l <= r){
            mid = (l+r)/2;
            int right = mid+1 < n ? nums[mid+1] : Integer.MIN_VALUE;
            if(nums[mid] < right)
                l = mid+1;
            else
                r= mid-1;
        }
        return l;
    }
}
