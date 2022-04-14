package solutions.GraphProblems;

import java.util.LinkedList;
import java.util.List;

public class CourseSchedule {
    class Vertex{
        List<Integer> edges;
        int order;
        Vertex(){
            edges = new LinkedList<>();
        }
        void addEdge(int i){
            edges.add(i);
        }
    }
    boolean[] tmp_mark;
    boolean[] perm_mark;
    int cur_unmarked;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Vertex[] vertices = new Vertex[numCourses];
        for ( int i=0 ; i < numCourses; i++){
            vertices[i] = new Vertex();

        }
        for(int[] pre : prerequisites){

            vertices[pre[1]].addEdge(pre[0]);
        }
         tmp_mark = new boolean[numCourses];
         perm_mark = new boolean[numCourses];
         cur_unmarked = numCourses;
        for(int i=0;i<numCourses; i++){
            if(!perm_mark[i]){
                if(!visit(vertices,i))
                    return false;
            }
        }
        return true;
    }
    boolean visit(Vertex[] vs,int i){
        if(perm_mark[i])
            return true;
        if(tmp_mark[i])
            return false;
        tmp_mark[i] = true;
        for(int edge : vs[i].edges ){
            if(!visit(vs,edge))
                return false;
        }
        tmp_mark[i] = false;
        perm_mark[i] = true;
        vs[i].order = cur_unmarked;
        cur_unmarked--;
        return true;
    }

    public static void main(String[] args) {
        CourseSchedule c = new CourseSchedule();
        int[][] pr = {{1,3}};
        boolean b = c.canFinish(2,new int[][] {{1,0},{0,1}});
        System.out.println(b);
    }
}
