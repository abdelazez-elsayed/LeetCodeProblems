package solutions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class NQueensII {
    Set<Integer> columnSet;
    Set<Integer> digSet;
    Set<Integer> xdigSet;

    int n;
    int ans = 0;
    public int totalNQueens(int n) {
        this.n = n;
        columnSet = new HashSet<>();
        digSet = new HashSet<>();
        xdigSet = new HashSet<>();
        build(0);
        return ans;
    }
    void build(int row){
        if(row == n) {
            ans++;
            return;
        }
        for(int j=0;j<n; j++){
            if(!columnSet.contains(j) && !digSet.contains(j+row) && !xdigSet.contains(row-j)){
                columnSet.add(j);
                digSet.add(j+row);
                xdigSet.add(row-j);
                build(row+1);
                columnSet.remove(j);
                digSet.remove(j+row);
                xdigSet.remove(row-j);
            }
        }
    }
}
