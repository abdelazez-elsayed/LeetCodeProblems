package solutions.GeneralProblems;

public class ValidSoduko {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        boolean[][] row_contains = new boolean[n][n];
        boolean[][] column_contains = new boolean[n][n];
        boolean[][] box_contains = new boolean[n][n];
        int num, boxJ, boxI, boxNum;
        for(int i=0; i<n; i++ ){
            boxI = (i/ 3)*3;
            for(int j=0; j<n; j++){
                if(board[i][j]=='.')
                    continue;
                num = board[i][j]-'1';
                boxJ = j / 3;
                boxNum = boxI+boxJ;
                if(row_contains[i][num] || column_contains[j][num] || box_contains[boxNum][num])
                    return false;
                row_contains[i][num] = true;
                column_contains[j][num] = true;
                box_contains[boxNum][num] = true;
            }
        }
        return true;
    }
}
