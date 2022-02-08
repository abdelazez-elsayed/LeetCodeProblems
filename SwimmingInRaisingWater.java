package solutions;

import java.util.*;

public class SwimmingInRaisingWater {
    static class Node{
        int i,j,cost;
        Node(int _i, int _j, int _cost){
            i = _i;
            j = _j;
            cost = _cost;
        }
        public boolean equals(Object node){
            if(!(node instanceof Node))
                return false;
            Node n = (Node) node;
            return this.i == n.i && this.j == n.j;
        }

        public int hashCode(){
            return (""+i+","+j).hashCode();
        }
    }
    int n,m;
    int[][] grid;
    boolean[][] visited;
    public int swimInWater(int[][] grid) {
        Node start = new Node(0, 0, grid[0][0]);
        n = grid.length;
        m = grid.length;
        this.grid= grid;
        visited = new boolean[n][m];
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
        queue.add(start);
        Set<Node> set = new HashSet<>();
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(visited[node.i][node.j])
                continue;
            /*if(set.contains(node))
                continue;*/
            //set.add(node);
            visited[node.i][node.j] = true;
            if(node.i == n-1 && node.j == m-1)
                return node.cost;
            List<Node> childs = getChilds(node);
            for(Node child : childs){
                if(visited[child.i][child.j])
                    continue;
               /* if(set.contains(child))
                    continue;*/
                if(child.cost < node.cost)
                    child.cost = node.cost;
                queue.add(child);
            }
        }
        return -1;
    }
    int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
    List<Node> getChilds(Node par){
        List<Node> ans = new LinkedList<>();
        for(int[] dir : dirs){
            int x = par.i + dir[0];
            int y = par.j + dir[1];
            if(x >= 0 && x < n && y >= 0 && y < m){
                Node child = new Node(x, y, grid[x][y]);
                ans.add(child);
            }
        }
        return ans;
    }
}
