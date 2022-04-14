package solutions;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathVisitingAllNodes {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        if(n == 1)
            return 0;
        int endMask = (1 << n) - 1;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][endMask+1];
        for(int i=0; i<n; i++){
            visited[i][1<<i] = true;
            queue.add(new int[] {i , 1 << i});
        }

        int steps=0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int k = 0 ; k < size; k++){
                int[] pair = queue.poll();
                int node = pair[0];
                int mask = pair[1];

                for(int nei : graph[node]){
                    int nodeMask = mask | (1 << nei );
                    if(nodeMask == endMask)
                        return 1+steps;
                    if(!visited[nei][nodeMask]){
                        visited[nei][nodeMask] = true;
                        queue.add(new int[]{nei,nodeMask });
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
