package solutions.SortingAndSearchingAndSelctionProblems;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

import static Datastructure.Utils.swap;

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<>();
        for(int num : nums){
            if(q.size() >= k && q.peek() < num){
                q.poll();
                q.add(num);
            }else if(q.size() < k){
                q.add(num);
            }
        }

        return q.peek();
    }

    int find(int [] nums , int k){
        return quickSelect(nums,0,nums.length-1,k-1);
    }
    public int rand(int min, int max)
    {
        if (min > max) {
            throw new IllegalArgumentException("Invalid range");
        }
        return new Random().nextInt(max - min + 1) + min;
    }
    public int quickSelect(int[] nums, int left, int right, int k)
    {
        // If the array contains only one element, return that element
        while (left < right){
            int pIndex = rand(left, right);

            pIndex = partition(nums, left, right, pIndex);
            if(pIndex == k)
                return nums[pIndex];
            else if(pIndex > k){
                right = pIndex-1;
            }else{
                left = pIndex + 1;
            }
        }
        return nums[left];/*
        if (left == right) {
            return nums[left];
        }

        // select a `pIndex` between left and right
        int pIndex = rand(left, right);

        pIndex = partition(nums, left, right, pIndex);

        // The pivot is in its final sorted position
        if (k == pIndex) {
            return nums[k];
        }

        // if `k` is less than the pivot index
        else if (k < pIndex) {
            return quickSelect(nums, left, pIndex - 1, k);
        }

        // if `k` is more than the pivot index
        else {
            return quickSelect(nums, pIndex + 1, right, k);
        }*/
    }

    public  int partition(int[] nums, int left, int right, int pIndex)
    {
        // pick `pIndex` as a pivot from the array
        int pivot = nums[pIndex];

        // Move pivot to end
        swap(nums, pIndex, right);

        // elements less than the pivot will be pushed to the left of `pIndex`;
        // elements more than the pivot will be pushed to the right of `pIndex`;
        // equal elements can go either way
        pIndex = left;

        // each time we find an element less than or equal to the pivot, `pIndex`
        // is incremented, and that element would be placed before the pivot.
        for (int i = left; i < right; i++)
        {
            if (nums[i] >= pivot)
            {
                swap(nums, i, pIndex);
                pIndex++;
            }
        }

        // move pivot to its final place
        swap(nums, pIndex, right);

        // return `pIndex` (index of the pivot element)
        return pIndex;
    }


    public static void main(String[] args) {
        int[] arr = {100, -1,3,2,1,5,6,4,8,9};
        int[] nums = {7,6,5,4,3,2,1};
        int k = 1;
        System.out.println(Arrays.toString(Arrays.copyOf(nums, 1)));
        KthLargestElement kth = new KthLargestElement();
        int ans = kth.find(nums,k);
        System.out.println(ans);
    }
}
