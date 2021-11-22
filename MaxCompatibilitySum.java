package solutions;

import java.util.Arrays;

public class MaxCompatibilitySum {
    int result=0;
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        boolean[] taken = new boolean[mentors.length];
        solve(students,
                mentors,
                taken,
                0,
                0);
        return result;
    }
    public void solve(int[][] students, int[][] mentors,boolean[] taken,int idx, int score){
        if(idx >= students.length)
            result = Math.max(result,score);
        int comScore=0;
        for(int i=0; i< students.length;i++){
            if(!taken[i]){
                    taken[i]=true;
                   comScore= getCompt(students[i],mentors[idx]);
                   solve(students,mentors,taken,idx+1,score+comScore);
                   taken[i]=false;
            }
        }
    }
    private int getCompt(int[] a1,int[] a2){
        int c=0;
        for(int i=0;i< a1.length;i++) if (a1[i] == a2[i]) c++;
            return c;
    }
}
