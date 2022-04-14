package solutions.BacktrackingProblems;

import java.util.*;

public class NQueens {
    Set<Integer> columnSet;
    Set<Integer> digSet;
    Set<Integer> xdigSet;
    char[][] board;
    int n;
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        res = new LinkedList<>();
        board = new char[n][n];
        columnSet = new HashSet<>();
        digSet = new HashSet<>();
        xdigSet = new HashSet<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        build(0);
        return res;
    }
    void buildAns(){
        List<String> ans = new ArrayList<>(n);
        for(int i=0; i<n; i++){
            ans.add(new String(board[i]));
        }
        res.add(ans);
    }
    void build(int row){
        if(row == n)
            buildAns();
        for(int j=0;j<n; j++){
            if(!columnSet.contains(j) && !digSet.contains(j+row) && !xdigSet.contains(row-j)){
                board[row][j] = 'Q';
                columnSet.add(j);
                digSet.add(j+row);
                xdigSet.add(row-j);
                build(row+1);
                board[row][j] = '.';
                columnSet.remove(j);
                digSet.remove(j+row);
                xdigSet.remove(row-j);
            }
        }
    }
}
