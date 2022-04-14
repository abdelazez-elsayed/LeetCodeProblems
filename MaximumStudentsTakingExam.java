package solutions;

import java.util.HashMap;
import java.util.Map;

public class MaximumStudentsTakingExam {
    Map<Integer,Integer> map;
    char  st = '1';
    int n,m;
    char[][] seats;
    int ans = 0;
    public int maxStudents(char[][] seats) {
        map = new HashMap<>();
        this.n = seats.length;
        this.m = seats[0].length;
        this.seats = seats;
        return backTracking(0,0,0);
    }
    int backTracking(int pos,int prevRow,int curRow){
        if(pos == n*m)
            return 0;
        if(map.containsKey(pos<<22 | prevRow << 10 | curRow))
            return map.get(pos<< 22 | prevRow << 10 | curRow);
        int i = pos/m;
        int j = pos%m;
        if(j == 0){
            prevRow = curRow;
            curRow = 0;
        }
        int cur_with = curRow | 1 << j+1;
        int cur_without = curRow;

        if(check(i,j)){

            seats[i][j] = st;
            int r1 = backTracking(pos+1,prevRow,cur_with)+1;
            seats[i][j] = '.';
            int r2 = backTracking(pos+1,prevRow,cur_without);
            int ans = Math.max(r1,r2);
            map.put(pos<< 22 | prevRow << 10 | curRow, ans);
            return ans;

        }else{
            int ans = backTracking(pos+1,prevRow,cur_without);
            map.put(pos<< 22 | prevRow << 10 | curRow,ans);
            return ans;
        }
    }

    boolean check(int i, int j){
        //check right
        if(seats[i][j] == '#')
            return false;
        if(j+1 < m){
            if(seats[i][j+1] == st)
                return false;
        }
        //check left
        if(j-1 >= 0){
            if(seats[i][j-1] == st)
                return false;
        }
        //check up right
        if(j+1 < m && i-1 >= 0){
            if(seats[i-1][j+1] == st)
                return false;
        }
        //check up left
        if(i-1 >= 0 && j-1 >= 0){
            return seats[i - 1][j - 1] != st;
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] arr =  {{'#','.','#'},{'#','#','.'},{'.','#','.'}};
        MaximumStudentsTakingExam m = new MaximumStudentsTakingExam();
        int r= m.maxStudents(arr);
        System.out.println(r);
    }
}
