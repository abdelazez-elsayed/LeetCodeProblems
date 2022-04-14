package solutions.DesignAndDatastructuresProblems;
class AlreadyTakenException extends Exception {
    public AlreadyTakenException()
    {
        super("This place has been taken");
    }
}
class GameEndException extends Exception{
    public GameEndException()
    {
        super("Game has been ended, cannot make any more moves");
    }
}
class TicTacToe {

    /** Initialize your data structure here. */
    /** Initialize your data structure here. */
    int[][] board;
    final int X = 1;
    final int O = -1;
    boolean xTurn;
    boolean gameEnded;
    int plays;
    public TicTacToe() {
        board = new int[3][3];
        xTurn = true;
        gameEnded = false;
        plays = 0;

    }

    public boolean move(int row, int col) throws AlreadyTakenException, GameEndException {
        if(board[row][col] != 0)
            throw new AlreadyTakenException();
        if(gameEnded)
            throw new GameEndException();
        if(xTurn){
            board[row][col] = X;
            if(check_end(X,row,col)){
                gameEnded = true;
                System.out.println("x player wins!");
                return true;
            }
        }else{
            board[row][col] = O;
            if(check_end(O,row,col)){
                gameEnded = true;
                System.out.println("o player wins!");
                return true;
            }
        }
        plays++;
        if(draw()){
            gameEnded = true;
            System.out.println("it's a draw");
            return true;
        }
        xTurn = !xTurn;
        return false;

    }
    boolean draw(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[i][j] == 0)
                    return false;
            }
        }
        return true;
    }
    boolean check_end(int player, int x,int y){
        //check column
        int cnt=1;
        int l=x-1;
        int r=x+1;
        while(l >= 0 || r < 3){
            if(l >= 0){
                if(board[l][y] == player)
                    cnt++;
                l--;
            }
            if(r < 3){
                if(board[r][y] == player)
                    cnt++;
                r++;
            }
        }
        if(cnt == 3)return true;
        //check row
        cnt = 1;
        l = y-1;
        r = y+1;
        while(l >= 0 || r < 3){
            if(l >= 0){
                if(board[x][l] == player)
                    cnt++;
                l--;
            }
            if(r < 3){
                if(board[x][r] == player)
                    cnt++;
                r++;
            }
        }
        if(cnt == 3)return true;
        if(x!=y) return false;
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2]== player)
            return true;
        return board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[2][0]== player;

    }

    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
        int[][] plays = {{1,0},{1,1},{0,2},{1,1},{1,0},{0,1},{1,2},{0,2},{1,1},{0,1},{1,0},{0,2},{2,2}
                        ,{2,2},{0,0},{1,2},{2,0},{2,1}};
        for(int[] play : plays){
            try {
                t.move(play[0],play[1]);
            } catch (AlreadyTakenException | GameEndException ignored) {
            }
        }
    }
}


