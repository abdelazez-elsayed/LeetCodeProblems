package solutions.GraphProblems;

import java.util.*;

public class CheapestFlightWithKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] info = new int[n][3];
        for(int i=0; i<n; i++){
            info[i][0] = i;
            info[i][1] = Integer.MAX_VALUE;
            info[i][2] = n;
        }
        info[src][0] =src;
        info[src][1] = 0;
        info[src][2] = 0;
        LinkedList<int[]>[] verts = new LinkedList[n];
        for(int i = 0 ; i<n ; i++)
            verts[i] = new LinkedList<>();
        for(int[] flight : flights){
            verts[flight[0]].add(new int[] {flight[1],flight[2],n});
        }
        if(verts[src].isEmpty())
            return -1;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e[1]));
        queue.add(new int[] {src,0,0 });
        while (!queue.isEmpty()){
            int[] vertx = queue.poll();
            if(vertx[0] == dst)
                return vertx[1];
            if(vertx[2] == k+1)
                continue;
            for(int[] neighbour : verts[vertx[0]]){
                int alt = neighbour[1] + vertx[1];
                if(alt < info[neighbour[0]][1]){
                    info[neighbour[0]][1] = alt;
                    int[] node = new int[] {neighbour[0],alt,vertx[2]+1};
                    queue.offer(node);

                }else if(vertx[2] < info[neighbour[0]][2]){
                    int[] node = new int[] {neighbour[0],alt,vertx[2]+1};
                    queue.offer(node);
                }
                info[neighbour[0]][2] = vertx[2];
            }
        }


        return info[dst][1] == Integer.MAX_VALUE ? -1 : info[dst][1];
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
        int src= 0;
        int dst = 2;
        int k = 1;

        CheapestFlightWithKStops c = new CheapestFlightWithKStops();
        int ans = c.findCheapestPrice(n,flights,src,dst,k);
        System.out.println(ans);
    }
}
