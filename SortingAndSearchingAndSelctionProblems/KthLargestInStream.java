package solutions.SortingAndSearchingAndSelctionProblems;

import java.util.PriorityQueue;

public class KthLargestInStream {
    PriorityQueue<Integer> heap;
    int k;
    public KthLargestInStream(int k,int[] nums){
        this.heap = new PriorityQueue<>();
        for(int num : nums)
            heap.offer(num);
        this.k = k;

        while(heap.size() > k)
            heap.poll();
    }
    public int add(int val) {
     heap.offer(val);
        if (heap.size() > k) {
            heap.poll();
        }
        return heap.peek();
    }


    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        int k = 2;
    }

}
