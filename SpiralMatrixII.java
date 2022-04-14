package solutions;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int cnt =1 ,l = 0 , r = n-1 , t = 0 , b = n-1;
        int end = n*n;
        while(cnt != end+1){
            for(int i=l; i <= r; i++)
                arr[t][i] = cnt++;
            t++;
            for(int i=t; i <= b; i++)
                arr[i][r] = cnt++;
            r--;
            for(int i = r; i >= l; i--)
                arr[b][i] = cnt++;
            b--;
            for(int i=b; i>=t; i--)
                arr[i][l] = cnt++;
            l++;

        }
        return arr;
    }
}
