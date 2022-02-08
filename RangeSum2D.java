package solutions;

public class RangeSum2D {
    int[][] sum;
    int n;
    int m;
    public RangeSum2D(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        sum = new int[matrix.length][matrix[0].length];
        sum[0][0] = matrix[0][0];
        for(int i=1; i<m; i++){
            sum[0][i] = matrix[0][i] + sum[0][i-1];
        }
        for(int i=1; i<n; i++){
            sum[i][0] = sum[i-1][0] + matrix[i][0];
            for(int j=1; j<m; j++){
                sum[i][j] = matrix[i][j] + sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = 0;
        ans += sum[row2][col2];
        int i,j;
        i = row2;
        j = col1-1;
        if(j >= 0)
            ans -= sum[i][j];
        i= row1-1;
        j= col2;
        if(i >= 0)
            ans -= sum[i][j];
        i = row1-1;
        j = col1-1;
        if(i >= 0 && j >= 0)
            ans += sum[i][j];
        return ans;

    }
}
