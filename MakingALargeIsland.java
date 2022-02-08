package solutions;

import java.util.*;
import solutions.Datastructure.Point;

public class MakingALargeIsland {
    int n;
    boolean[][] visited;
    int[][] grid;
    int[] x_dir = {1,-1,0,0};
    int[] y_dir = {0,0,1,-1};
    HashMap<Point,Integer> groups;
    HashMap<Integer,Integer> groupSize;

    int dfs (int i, int j,int groupID){
        visited[i][j] =true;
        int ans = 0;
        for(int k=0; k < 4; k++){
            int x = i + x_dir[k];
            int y = j + y_dir[k];
            if(isValid(x,y,grid,n*n)){
                groups.put(new Point(x,y),groupID);
                ans += dfs(x,y,groupID);
            }
        }
        return ans+1;
    }
    List<Point> getNeighbours(int i,int j){
        List<Point> list = new ArrayList<>();
        for(int k=0; k<4;k++){
            int x = i+x_dir[k];
            int y = j+y_dir[k];
            if(x< 0 || x >= n || y < 0 || y >= n || grid[x][y] != 1)
                continue;
            Point p = new Point(x,y);
            list.add(p);
        }
        return list;
    }
    int getPoinstMerge(Point p1, Point p2){
        if(groups.get(p1).equals(groups.get(p2)))
            return groupSize.get(groups.get(p1))+1;
        else
            return groupSize.get(groups.get(p1))+groupSize.get(groups.get(p2))+1;
    }
    public int largestIsland(int[][] grid) {
        groupSize = new HashMap<>();
        n = grid.length;
        this.grid = grid;
        int groupsId = 0;
        groups = new HashMap<>();
        visited= new boolean[n][n];

        for(int i=0; i < grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                Point p = new Point(i,j);
                if(grid[i][j] == 1 && !groups.containsKey(p)){
                    groups.put(p,groupsId);
                    int ans = dfs(i,j,groupsId);
                    groupSize.put(groupsId,ans);
                    groupsId++;
                }
            }
        }
        int ans= 0;
        boolean hasZero = false;
        for(int i=0; i < grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 0){
                    hasZero = true;
                    List<Point> list = getNeighbours(i,j);
                    HashSet<Integer> set = new HashSet<>();
                    for(Point np : list)
                        set.add(groups.get(np));
                    int sum=0;
                    for(Integer g : set)
                        sum += groupSize.get(g);
                    ans = Math.max(ans,sum+1);
                }
            }
        }
        if(hasZero && ans == 0)
            return 1;
        return ans==0 ? n*n : ans;


    }
    boolean isValid(int i,int j,int[][] grid,int lv){

        if(i < 0 || i >= n || j < 0 || j >= n)
            return false;
        if(visited[i][j])
            return false;
        Point p = new Point(i,j);
        if(groups.containsKey(p))
            return false;
        return grid[i][j] != 0 && grid[i][j] < lv;
    }

    public static void main(String[] args) {
        MakingALargeIsland m = new MakingALargeIsland();
        int[][] grid = {{0,0},{0,1}};
        System.out.println(m.largestIsland(grid));
    }

}
