package solutions.GraphProblems;

import java.util.*;

public class WordSearch {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        // write your code here

        visited = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean ans= traverse(board,word,i,j,0);
                    if(ans)
                        return ans;
                }
            }
        }
        return false;
    }
    boolean traverse(char[][] board, String word, int i, int j , int idx){
        if(visited[i][j])
            return false;

        if(idx == word.length()-1 && word.charAt(idx) == board[i][j]){
            return true;
        }

        boolean ans;
        visited[i][j] = true;
        if(i-1 >= 0 && board[i-1][j] == word.charAt(idx+1)){
            ans = traverse(board,word,i-1,j,idx+1);
            if(ans){
                return ans;
            }
        }
        if(i+1 < board.length && board[i+1][j] == word.charAt(idx+1) ){
            ans = traverse(board,word,i+1,j,idx+1);
            if(ans){
                return ans;
            }
        }
        if(j-1 >= 0 && board[i][j-1] == word.charAt(idx+1) ){
            ans = traverse(board,word,i,j-1,idx+1);
            if(ans){
                return ans;
            }
        }

        if(j+1 < board[0].length && board[i][j+1] == word.charAt(idx+1)){
            ans = traverse(board,word,i,j+1,idx+1);
            if(ans){
                return ans;
            }
        }
        visited[i][j] = false;
        return false;
    }
}
