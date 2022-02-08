package solutions;

public class FarestFromLand {

    int n;
    int[] x_dir = {1,-1,0,0};
    int[] y_dir = {0,0 ,1,-1};
    /**
     * @param grid: An array.
     * @return: An integer.
     */
    public int maxDistance(int[][] grid) {
        // Write your code here.
        n = grid.length;
        boolean loop = true;
        int steps=0;
        int[][] my_grid = new int[n][n];
        for(int i=0; i<n; i++) System.arraycopy(grid[i], 0, my_grid[i], 0, n);
        while (loop){
            steps++;
            loop=false;
            for(int i=0;i<n;i++){
                for (int j=0; j<n; j++){
                    if(my_grid[i][j] == 0 || my_grid[i][j] > steps)
                        continue;
                    for(int k=0; k<4; k++){
                        int x = i+x_dir[k];
                        int y = j+y_dir[k];
                        if(!isValid(x,y) || my_grid[x][y] != 0)
                            continue;
                        my_grid[x][y] = steps+1;
                        loop =true;
                    }
                }
            }
        }
        return steps == 1 ? -1 : steps-1;
    }

    boolean isValid(int i,int j){
        return (i >= 0 && i < n) && (j >= 0 && j < n);
    }

    public static void main(String[] args) {
        FarestFromLand f = new FarestFromLand();
        int[][] grid = {{1,0,0},
                        {0,0,0},
                        {0,0,0}};
        System.out.println(f.maxDistance(grid));
    }
}
