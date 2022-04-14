package solutions.GeneralProblems;

import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length,m = matrix[0].length;
        int ans = 0;
        int[] heights = new int[m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j] == '1')
                    heights[j]++;
                else
                    heights[j]=0;
                System.out.print(heights[i]+",");
            }
            int pos = largestRectangleArea(heights);
            ans = Math.max(ans,pos);
        }
        return ans;
    }
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        for(int i=0; i < n; i++){
            int start = i;
            while(!stack.isEmpty() && stack.peek()[1] > heights[i]){
                maxArea = Math.max(maxArea, stack.peek()[1] * (i - stack.peek()[0]));
                start = stack.peek()[0];
                stack.pop();
            }
            stack.push(new int[]{start,heights[i]});
        }
        while(!stack.isEmpty()){

            maxArea = Math.max(maxArea, stack.peek()[1] *(n- stack.pop()[0]));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        char[][] arr= {{'1','0'}};
        MaximalRectangle m = new MaximalRectangle();
        int ans = m.maximalRectangle(arr);
        System.out.println(ans);
    }
}
