package solutions.GraphProblems;

import java.util.Arrays;

public class RedundantConectionII {
    /*
    we try to build a disjoint set
    whenever we met a cycle or a child with existing parent we check whether current
    edge is forming the problem if so return it
    else check the other edge that's pointing to the child
    check if this edge is the problem, if so return it
     if not so there's another edge that causing the problem
     */
    public int[] findRedundantDirectedConnection(int[][] edges) {
        DSU dsu = new DSU(1001);
        for(int[] edge : edges){
            //if we can't build disjoint set
            if(!dsu.unionByParent(edge[0],edge[1])){
                //try to build graph without that edge
                if(tryExcept(edges,edge)){//if so --> this edge is the cause of problem , return it
                    return edge;
                }else{
                    //else find the other edge that's is pointing to that child
                    int[] e = findEdge(edges,edge[1]);
                    //if it's the cause of problem return it
                    if(tryExcept(edges,e))
                        return e;
                }
            }
        }
        //We never reaches here unless we failed to find a problem
        return new int[] {-1,-1};
    }
    /*
    a function that's try to build a graph without an edge (except)
    returns true if it succeeds, false otherwise
     */
    boolean tryExcept(int[][] edges,int[] except){

        DSU dsu = new DSU(1001);
        for(int[] edge: edges){
            if(edge == except)
                continue;
            if(!dsu.unionByParent(edge[0],edge[1]))
                return false;
        }
        return true;
    }
    //Finds the first edge that has this child as its child
    public int[] findEdge(int[][] edges,int child){
        for(int[] edge:edges){
            if(edge[1] == child)
                return edge;
        }
        //we never reaches here (unless this edge doesn't exist)
        return new int []{-1,-1};
    }
}
class DSU {
    int[] representative;
    int[] size;

    public DSU(int sz) {
        representative = new int[sz];
        for (int i = 0; i < sz; ++i) {
            // Initially each group is its own representative
            representative[i] = i;
        }
    }

    // Finds the representative of group x
    public int findRepresentative(int x) {
        if (x == representative[x]) {
            return x;
        }
        // This is path compression
        return representative[x] = findRepresentative(representative[x]);
    }

    // Unite the group by the parent
    //returns false if parent and child are in the same group or the child has a parent
    // returns true otherwise
    public boolean unionByParent(int parent, int child) {
        int representativeParent = findRepresentative(parent);
        int representativeChild = findRepresentative(child);
        // If child has a parent return false
        //or the child and parent are belong to same group (forming a cycle) return false
        if(representativeChild != child || representativeParent == representativeChild ){
            return false;
        }
        // Union by parent
        representative[child] = representativeParent;
        return true;
    }

    public static void main(String[] args) {
        int[][] edges = {{3,4},{4,1},{1,2},{2,3},{5,1}};
        RedundantConectionII r = new RedundantConectionII();
        int[] ans = r.findRedundantDirectedConnection(edges);
        System.out.println(Arrays.toString(ans));
    }
}
