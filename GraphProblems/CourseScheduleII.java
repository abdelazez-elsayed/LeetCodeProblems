package solutions.GraphProblems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CourseScheduleII {
    int n;
    boolean[] tmp_mark;
    boolean[] perm_mark;
    LinkedList<Integer> sol;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        n = numCourses;
        tmp_mark = new boolean[n];
        perm_mark = new boolean[n];
        List<Integer>[] vertices = new LinkedList[numCourses];
        sol = new LinkedList<>();
        for(int i=0; i<n; i++)
            vertices[i] = new LinkedList<>();
        for(int[] pr : prerequisites ){
            vertices[pr[1]].add(pr[0]);
        }
        for(int i=0; i<n;i++){
            if(!perm_mark[i]){
                if(!visit(vertices,i)){
                    return new int[]{};
                }
            }
        }
        int[] ans = new int[n];
        int i=0;
        for(int co : sol){
            ans[i++] = co;
        }
        return ans;

    }
    boolean visit(List<Integer>[] vertices, int i){
        if(perm_mark[i])
            return true;
        if(tmp_mark[i])
            return false;
        tmp_mark[i] = true;
        for(int edge : vertices[i]){
            if(!visit(vertices,edge))
                return false;
        }
        tmp_mark[i] = false;
        perm_mark[i] = true;
        sol.addFirst(i);
        return true;
    }

    public static void main(String[] args) {
        CourseScheduleII c = new CourseScheduleII();
        int[][] arr = {{1,0},{2,0},{3,1},{3,2}};
        int n = 4;
        int[] ans = c.findOrder(n,arr);
        System.out.println(Arrays.toString(ans));
    }
}
