package solutions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class BestMeetingPoint {
    int n;
    int m;
    int[][] grid;
    boolean[][] visited;
    int getDist(ArrayList<Integer> list){
        int l=0,r=list.size()-1;
        int sum =0;
        while( l < r)
            sum += list.get(r--) - list.get(l++);
        return sum;
    }
    public int minTotalDistance(int[][] grid) {
        // Write your code here
        n = grid.length;
        m = grid[0].length;
        this.grid = grid;
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> cols = new ArrayList<>();
        for(int i=0; i < n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        //rows.sort(Comparator.comparingInt(a -> a));
        cols.sort(Comparator.comparingInt( a->a));
        return getDist(rows) + getDist(cols);

       /* int x = rows.get(rows.size()/2);
        int y = cols.get(cols.size()/2);
        visited = new boolean[n][m];
        Queue<Integer> queue = new LinkedList<>();
        int p = x*m+y;
        queue.offer(p);
        int dist = 0;
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        int sum = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int k=0; k<size; k++){
                p = queue.poll();
                int i = p/m;
                int j = p%m;
                visited[i][j] = true;
                if(grid[i][j] == 1)
                    sum += dist;
                for(int q=0; q<4; q++){
                    x = i+dirs[q][0];
                    y = j+dirs[q][1];
                    if(isValid(x,y)){
                        visited[x][y] = true;
                        queue.add(x*m+y);
                    }
                }
            }
            dist++;
        }
        return sum;*/
    }
    boolean isValid(int i , int j){
        if(i < 0 || i >= n  || j<0 || j>=m || visited[i][j])
            return false;
        return true;
    }

    public static void main(String[] args) {
        int[][] arr = {{0,0,0,0,1,0,1,0},
                       {0,0,0,0,1,0,0,1}};
        BestMeetingPoint b = new BestMeetingPoint();
        int ans = b.minTotalDistance(arr);
        System.out.println(ans);
    }
}
