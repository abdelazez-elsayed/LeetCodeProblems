package solutions.DPProblems;

import java.util.List;

public class Triangle_120 {
    Integer[][] memo;
    int nr;
    List<List<Integer>> list;
    public int minimumTotal(List<List<Integer>> triangle) {
        nr = triangle.size();
        list = triangle;
        memo = new Integer[nr][nr];
        return find(0,0);
    }
    int find(int row , int column){
        if(row == nr)
            return 0;
        if(column >= list.get(column).size())
            return Integer.MAX_VALUE;
        if(memo[row][column] != null)
            return memo[row][column];

        int val = list.get(row).get(column);

        int min = Math.min(find(row+1,column), find(row+1,column+1));
        return memo[row][column] = min+val;
    }
}
