package solutions.ArraysAndNumbersProblems;

import java.util.Arrays;

public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean setFirstRow=false,setFirstColumn = false;
        for (int[] ints : matrix) {
            if (ints[0] == 0) {
                setFirstColumn = true;
                break;
            }
        }
        for(int j=0; j<m; j++){
            if (matrix[0][j] == 0) {
                setFirstRow = true;
                break;
            }
        }
        for(int i = 1; i<n; i++){
            for(int j=1; j<m; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }

        for(int i=1; i < n ; i++){
            if(matrix[i][0] == 0){
                for(int j=0;j<m;j++)
                    matrix[i][j] = 0;
            }
        }
        for(int j=1; j<m; j++){
            if(matrix[0][j] == 0){
                for(int i=1; i<n; i++)
                    matrix[i][j] = 0;
            }
        }
        if(setFirstRow)
            Arrays.fill(matrix[0],0);
        if(setFirstColumn){
            for(int i=0; i < n; i++)
                matrix[i][0] = 0;
        }
    }
}
