package solutions.BacktrackingProblems;

public class SodukoSolver {
    int n;
    int sqrt_n;
    boolean[][] row_contains;
    boolean[][] column_contains;
    boolean[][] box_contains;
    char[][] board;
    public void solveSudoku(char[][] board) {

        n = board.length;
        sqrt_n = (int)Math.sqrt(n);
        if(board.length != board[0].length)
            throw new IllegalArgumentException("Not square board");
        if(sqrt_n * sqrt_n != n)
            throw new IllegalArgumentException("Not square board");
        row_contains = new boolean[n][n];
        column_contains = new boolean[n][n];
        box_contains = new boolean[n][n];

        int num, boxJ, boxI, boxNum;
        for(int i=0; i<n; i++ ){
            boxI = (i/ sqrt_n)*sqrt_n;
            for(int j=0; j<n; j++){
                if(board[i][j]=='.')
                    continue;
                num = board[i][j]-'1';
                boxJ = j / sqrt_n;
                boxNum = boxI+boxJ;
                row_contains[i][num] = true;
                column_contains[j][num] = true;
                box_contains[boxNum][num] = true;
            }
        }
        this.board = board;
        build(0);
    }
    boolean build(int pos){
        int i = pos/n;
        int j = pos%n;
        if(i==n)
            return true;
        if(board[i][j] != '.')
            return build(pos+1);
        int boxI = (i/ sqrt_n)*sqrt_n;
        int boxJ = j / sqrt_n;
        int boxNum = boxI+boxJ;
        for(int k=0; k< n; k++){
            if(row_contains[i][k] || column_contains[j][k] || box_contains[boxNum][k])
                continue;
            char num = (char)(k+'1');
            row_contains[i][k] = true;
            column_contains[j][k] = true;
            box_contains[boxNum][k] = true;
            board[i][j] = num;
            if(build(pos+1))
                return true;
            board[i][j] = '.';
            row_contains[i][k] = false;
            column_contains[j][k] =  false;
            box_contains[boxNum][k] =  false;
        }
        return false;
    }

    public static void main(String[] args) {
        SodukoSolver s = new SodukoSolver();
        String[][] sB = {{"5","3",".",".","7",".",".",".","."},
                          {"6",".",".","1","9","5",".",".","."},
                          {".","9","8",".",".",".",".","6","."},
                          {"8",".",".",".","6",".",".",".","3"},
                          {"4",".",".","8",".","3",".",".","1"},
                          {"7",".",".",".","2",".",".",".","6"},
                          {".","6",".",".",".",".","2","8","."},
                          {".",".",".","4","1","9",".",".","5"},
                          {".",".",".",".","8",".",".","7","9"}};
        char[][] board = toString(sB);
        s.solveSudoku(board);
    }

    private static char[][] toString(String[][] sB) {
        char[][] board = new char[sB.length][sB.length];
        for(int i=0; i < sB.length; i++){
            for(int j=0;j<sB.length; j++){
                board[i][j] = sB[i][j].charAt(0);
            }
        }
        return board;
    }
}
