package solutions;

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

}
