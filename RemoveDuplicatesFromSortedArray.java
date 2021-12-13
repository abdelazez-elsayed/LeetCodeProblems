package solutions;

public class RemoveDuplicatesFromSortedArray {
    /*
    Given a sorted array,
    'remove' the duplicates in place such that each element appear only once
     and return the 'new' length.
     Do not allocate extra space for another array,
     you must do this in place with constant memory.
     */
    public int removeDuplicates(int[] nums) {
        // write your code here

        if(nums == null)return 0;
        if(nums.length == 1)return 1;
        int pos=1;
        int n = nums.length;
        for(int i=0;i<nums.length;){
            int j=i+1;
            while(j < nums.length && nums[j] == nums[i])
                j++;

            if(j<n)
                nums[pos] = nums[j];
            pos++;
            i=j;
        }
        return pos-1;
    }
}
