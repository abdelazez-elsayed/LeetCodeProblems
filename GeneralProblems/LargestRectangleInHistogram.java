package solutions.GeneralProblems;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        for(int i=0; i < n; i++){
            int start = i;
            //if last element pushed is greater than me
            // so it can't be extended further
            // pop it but before popping calculate it's area (= Height * Current index)
            //save last index we can extend current element to backward (last popped element)
            while(!stack.isEmpty() && stack.peek()[1] > heights[i]){
                maxArea = Math.max(maxArea, stack.peek()[1] * (i - stack.peek()[0]));
                start = stack.peek()[0];
                stack.pop();
            }
            stack.push(new int[]{start,heights[i]});
        }

        //Remaining elements in stack can be extended as long the whole histogram
        //so calculate their area as their width is from n to its index;
        while(!stack.isEmpty()){
            maxArea = Math.max(maxArea, stack.peek()[1] *(n- stack.pop()[0]));
        }
        return maxArea;
    }
}
