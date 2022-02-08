package solutions;

import java.util.*;

// Definition for a Node.



class DeepCopyGraph{
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public Node cloneGraph(Node node) {
        Queue<Node> queue = new LinkedList<>();
        Map<Node,Node> map = new HashMap<>();
        if(node == null)
            return null;
        queue.add(node);
        Node ref_node = new Node(node.val);
        map.put(node,ref_node);

        while(!queue.isEmpty()){
            Node to_clone = queue.poll();
            Node copy_node = map.get(to_clone);
            for(Node to_clone_neighbour : to_clone.neighbors){
                Node neighbour_copy;
                if(!map.containsKey(to_clone_neighbour)){
                    neighbour_copy = new Node(to_clone_neighbour.val);
                    map.put(to_clone_neighbour,neighbour_copy);
                    queue.add(to_clone_neighbour);
                }else{
                    neighbour_copy = map.get(to_clone_neighbour);
                }
                copy_node.neighbors.add(neighbour_copy);
            }
        }
        return ref_node;
    }
}