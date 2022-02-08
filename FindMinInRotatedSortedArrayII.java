package solutions;

public class FindMinInRotatedSortedArrayII {
    int n;
    public int findMin(int[] nums) {
        n = nums.length;
        return findMin(nums,0,nums.length-1);

    }
    int findMin(int[] nums,int l,int r){
        if(r==-1)
            return nums[l];
        if(l == n)
            return nums[r];
        if (l+1 >= r){
            return Math.min(nums[l],nums[r]);
        }
        if(nums[r] > nums[0])
            return nums[0];
        int mid = (l+r)/2;
        int min=Integer.MAX_VALUE;
        if(nums[mid] < nums[l] && nums[mid] < nums[r])
            min = nums[mid];
        int left = l;
        int right = r;
        while(left <= right){
            mid = (left+right)/2;
            if(nums[mid] > nums[r]){
                left = mid+1;
            }else if(nums[mid] < nums[l]){
                right = mid-1;
            }else {
                return Math.min(min,Math.min(findMin(nums,mid+1,right),findMin(nums,left,mid-1)));
            }
        }
        if(mid+1 < n && nums[mid+1] < nums[mid])
            return nums[mid+1];
        return nums[mid];
    }

    public static void main(String[] args) {
        int[] arr = {10,10,1,10,10};
        FindMinInRotatedSortedArrayII f = new FindMinInRotatedSortedArrayII();
        System.out.println(f.findMin(arr));
    }
}
