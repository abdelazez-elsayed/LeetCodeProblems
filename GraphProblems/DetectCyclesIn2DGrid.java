package solutions.GraphProblems;

public class DetectCyclesIn2DGrid {
    boolean[][] visited;
    char[][] grid;
    int n;
    int m;
    int[] x_dir = {1,-1,0,0};
    int[] y_dir = {0,0,-1,1};
    public boolean containsCycle(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        this.grid = grid;
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(!visited[i][j]){
                    if(dfs(-1,-1,i,j))
                        return true;
                }
            }
        }
        return false;
    }
    boolean dfs(int row_prev,int col_prev,int row,int col){
        if(visited[row][col])
            return true;
        visited[row][col] = true;
        for(int i=0; i<x_dir.length; i++){
            int x = row + x_dir[i];
            int y = col + y_dir[i];
            if(x == row_prev && y == col_prev)
                continue;
            if(isValid(row,col,x,y)){
                boolean res = dfs(row,col,x,y);
                if(res)
                    return res;
            }
        }
        return false;
    }
    boolean isValid(int row_p, int col_p , int row , int col){
        if(row < 0 || row >= n || col < 0 || col >= m)
            return false;
        return grid[row_p][col_p] == grid[row][col];
    }
}
