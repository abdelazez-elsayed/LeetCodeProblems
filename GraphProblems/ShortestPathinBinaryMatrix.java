package solutions.GraphProblems;

import java.util.*;

public class ShortestPathinBinaryMatrix {
    int[] x_dir ={1,-1,0,0,1,-1,-1,1};
    int[] y_dir ={0,0,1,-1,1,-1,1,-1};
    int[][] grid;
    int n;
    public int shortestPathBinaryMatrix(int[][] grid) {
        this.grid = grid;
        Queue<int[]> queue = new LinkedList<>();
        n = grid.length;
        boolean[][] visited = new boolean[n][n];
        if(grid[0][0] == 1)
            return -1;
        if(n == 1 ){
            return 1;
        }
        visited[0][0] = true;
        queue.add(new int[]{0,0});
        int dist = 1;
        while(!queue.isEmpty()){
            int size  = queue.size();
            for(int i = 0 ; i<size; i++){
                int[] point = queue.poll();
                int x= point[0];
                int y= point[1];
                if(x == n-1 && y == n-1 )
                    return dist;
                List<int[]> neis = findNeighbours(x,y);
                for(int[] nei : neis ){
                    if(!visited[nei[0]][nei[1]]){
                        visited[nei[0]][nei[1]] = true;
                        queue.add(nei);
                    }
                }
            }
            dist++;
        }
        return -1;
    }
    List<int[]> findNeighbours(int x,int y){
        List<int[]> neis = new LinkedList<>();
        for(int i=0; i<x_dir.length; i++){
            int nx = x + x_dir[i];
            int ny = y + y_dir[i];
            if(isValid(nx,ny)){
                neis.add(new int[] {nx,ny});
            }
        }
        return neis;
    }
    boolean isValid(int i,int j){
        if(i < 0 || i >= n || j < 0 || j >= n || grid[i][j] == 1)
            return false;
        return true;
    }

    public static void main(String[] args) {
        int[][] mat = {{0,1},{1,0}};
        ShortestPathinBinaryMatrix s = new ShortestPathinBinaryMatrix();
        System.out.println(s.shortestPathBinaryMatrix(mat));
    }
}
