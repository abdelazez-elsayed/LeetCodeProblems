package solutions;

public class NumberOfIslands {
    boolean[][] visited;
    char[][] grid;
    int n;
    int m;
    int[] x_dir = {1,-1,0,0};
    int[] y_dir = {0,0,1,-1};
    public int numIslands(char[][] grid) {
        int ans = 0;
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m];
        for(int i=0; i < n; i++){
            for(int j=0; j<m; j++){
                if(isValid(i,j)){
                    ans++;
                    dfs(i,j);
                }
            }
        }

        return ans;
    }
    void dfs(int i,int j){
        if(!isValid(i,j))
            return;
        visited[i][j] = true;
        for(int k=0; k<x_dir.length; k++){
            int x = i + x_dir[k];
            int y = j + y_dir[k];
            dfs(x,y);
        }

    }
    boolean isValid(int i , int j){
        if(i < 0 || i >= n || j<0 || j>= m || grid[i][j] == '0' || visited[i][j])
            return false;
        return true;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},
                         {'1','1','0','1','0'},
                         {'1','1','0','0','0'},
                         {'0','0','0','0','0'}};
        NumberOfIslands n = new NumberOfIslands();
        System.out.println(n.numIslands(grid));
    }
}
