package solutions.DPProblems;

public class JumpGameIII {
    int n;
    int[] arr;
    boolean[] visited;
    public boolean canReach(int[] arr, int start) {
        n=arr.length;
        this.arr = arr;
        visited = new boolean[n];
        return Try(start);
    }
    boolean Try(int idx){
        if(idx < 0 || idx >= n)
            return false;
        if(arr[idx] == 0)
            return true;
        if(visited[idx])
            return false;
        visited[idx] = true;
        boolean left = Try(idx-arr[idx]);
        boolean right = Try(idx+arr[idx]);
        return left || right;
    }
    public static void main(String[] args) {
        JumpGameIII j= new JumpGameIII();
        int[] arr = {4,2,3,0,3,1,2};
        int start = 5;
        boolean ans = j.canReach(arr,start);
        System.out.println(ans);
    }
}
