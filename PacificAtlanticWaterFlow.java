package solutions;

import java.util.LinkedList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    boolean[][] canPacific;
    boolean[][] canAtlantic;
    boolean[][] visitedPacific;
    boolean[][] visitedAtlantic;
    int[][] heights;
    int n,m;
    int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n = heights.length;
        m = heights[0].length;
        this.heights = heights;
        canPacific = new boolean[n][m];
        canAtlantic = new boolean[n][m];
        visitedPacific = new boolean[n][m];
        visitedAtlantic = new boolean[n][m];
        for(int i=0; i<m; i++){
            canPacific[0][i] = true;
            canAtlantic[n-1][i] = true;
            //visitedPacific[0][i] = true;
            //visitedAtlantic[n-1][i] = true;

        }
        for(int i=0; i<n; i++){
            canPacific[i][0] = true;
            canAtlantic[i][m-1] = true;
            //visitedPacific[i][0] = true;
            //visitedAtlantic[i][m-1]=true;

        }
        for(int i=0; i<m; i++){
            dfs(0,i,canPacific,visitedPacific);
            dfs(n-1,i,canAtlantic,visitedAtlantic);

        }
        for(int i=0; i<n; i++){
            dfs(i,0,canPacific,visitedPacific);
            dfs(i,m-1,canAtlantic,visitedAtlantic);
        }
        List<List<Integer>> ans = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(canPacific[i][j] && canAtlantic[i][j]){
                    List<Integer> list = new LinkedList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }
        return ans;

    }
    boolean dfs(int i,int j ,boolean[][] can,boolean[][] visited){
        if(visited[i][j])
            return can[i][j];
        visited[i][j] = true;
        for(int[] dir : dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            if(isValid(i,j,x,y,visited)){
                can[x][y] = true;
                dfs(x,y,can,visited);
            }
        }

        return can[i][j];
    }
    boolean isValid(int i, int j , int x , int y,boolean[][] visited){
        if(x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || heights[x][y]  <  heights[i][j])
            return false;
        return true;
    }

    public static void main(String[] args) {
        int[][] h = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        PacificAtlanticWaterFlow p = new PacificAtlanticWaterFlow();
        List<List<Integer>> ans = p.pacificAtlantic(h);
        for(List<Integer> r : ans)
            System.out.println(r);
    }
}
