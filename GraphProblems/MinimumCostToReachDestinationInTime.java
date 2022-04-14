package solutions.GraphProblems;

import java.util.*;

public class MinimumCostToReachDestinationInTime {
    static class Node{
        int id,cost,time;
        Node(int _id , int _cost, int _time){
            id= _id;
            cost = _cost;
            time = _time;
        }
    }
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        ArrayList<Node>[] adj = new ArrayList[n];
        for(int i=0; i< edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int time = edges[i][2];
            if(adj[u] == null) adj[u] = new ArrayList<Node>();
            adj[u].add(new Node(v,passingFees[v],time));
            if(adj[v] == null) adj[v] = new ArrayList<Node>();
            adj[v].add(new Node(u,passingFees[u],time));
        }
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        queue.add(new Node(0,passingFees[0],0));
        int[] costs = new int[n];
        Arrays.fill(costs,Integer.MAX_VALUE);
        costs[0] = 0;
        int[] minTime = new int[n];
        Arrays.fill(minTime,Integer.MAX_VALUE);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            if(node.time > maxTime)
                continue;
            if(node.time >= minTime[node.id])
                continue;
            if(node.id == n-1)
                return node.cost;

            for(Node nei : adj[node.id]){
                int altr_cost = node.cost + nei.cost;
                if(altr_cost < costs[nei.id]) {
                    costs[nei.id] = altr_cost;
                    Node to_visit = new Node(nei.id,altr_cost,nei.time+node.time);
                    queue.offer(to_visit);
                }
                else if(nei.time < minTime[nei.id]){
                    Node to_visit = new Node(nei.id,altr_cost,nei.time+node.time);
                    queue.offer(to_visit);
                }
                minTime[node.id] = node.time;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] fees = {2,5};
        int[][] edgs = {{0,1,100}};
        int mxT = 100;
        MinimumCostToReachDestinationInTime m  = new MinimumCostToReachDestinationInTime();
        int ans = m.minCost(mxT,edgs,fees);
        System.out.println(ans);
    }
}
