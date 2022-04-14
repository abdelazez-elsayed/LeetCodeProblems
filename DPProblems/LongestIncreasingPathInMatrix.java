package solutions.DPProblems;

public class LongestIncreasingPathInMatrix {
    int[][] memo;
    int[][] matrix;
    int n;
    int m;
    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        this.matrix = matrix;
        memo = new int[n][m];
        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                ans = Math.max(ans,find(i,j));
            }
        }
        return ans;
    }
    int find(int i,int j){

        if(memo[i][j] != 0)
            return memo[i][j];
        int ans=1;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (isValid(i, j, x, y))
                ans = Math.max(ans, find(x, y) + 1);
        }
        return memo[i][j] = ans;
    }
    boolean isValid(int i,int j, int x, int y){
        return x >= 0 && y >= 0 && x < n && y < m && matrix[x][y] > matrix[i][j];
    }
}
