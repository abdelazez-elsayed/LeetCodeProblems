package solutions;

public class MazeSolver {
    int[][] dp;
    boolean[][] visited;


    int solve(int[][] arr){
        dp = new int[arr.length][arr[0].length];
        for(int i=0;i<arr.length;i++){
            for(int j=0; j<arr[0].length; j++)
                dp[i][j] = Integer.MAX_VALUE;
        }
        visited= new boolean[arr.length][arr[0].length];
        return dp_solve(arr,0,0,0);
    }

    private int dp_solve(int[][] arr, int i, int j, int len) {
        int n=arr.length;
        int m=arr[0].length;
        int sol = Integer.MAX_VALUE;

        //if We get out of array or we going through an obstacle, then return +inf
        // (i.e no path to exit through this node)
        if(i<0 || i>= n || j<0 || j>=m || arr[i][j] == 1) return Integer.MAX_VALUE;

        //if we get to exit, set solution to length, save it and return it
        if(j==m-1 && i==n-1) return dp[i][j] = len;
        //if we had visited this node, return its solution
        if(visited[i][j]) return dp[i][j];
        //else set this node to be visited and found its solution
        visited[i][j] = true;

        int left_len, right_len, up_len, down_len;
        //Go right
        right_len = dp_solve(arr,i,j+1, len+1);
        //go left
        left_len = dp_solve(arr,i,j-1,len+1);
        //Go Down
        down_len = dp_solve(arr,i+1, j,len+1);
        //Go UP
        up_len = dp_solve(arr,i-1, j,len+1);

        //Solution is the shortest path of the 4 directions;
        sol = Math.min(sol, down_len);
        sol = Math.min(sol, right_len);
        sol = Math.min(sol, left_len);
        sol = Math.min(sol, up_len);


        //save solution of that node and return it
        return dp[i][j]=sol;
    }

    public static void main(String[] args) {
        int[][]test1 = {{0,0,0}};

        int[][]test2 = {{0},
                        {0},
                        {0},
                        {0},
                        {0}};

        int[][]test3 = {{0,0,0},
                        {0,0,0},
                        {0,0,0}};

        int[][]test4 = {{0,1,0,0,0,1,0,0},
                        {0,1,0,1,0,1,0,0},
                        {0,0,0,1,0,0,0,0}};

        MazeSolver solver = new MazeSolver();
        System.out.println(solver.solve(test1));
        System.out.println(solver.solve(test2));
        System.out.println(solver.solve(test3));
        System.out.println(solver.solve(test4));


    }
}
