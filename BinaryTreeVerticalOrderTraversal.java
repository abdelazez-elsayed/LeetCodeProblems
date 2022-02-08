package solutions;

import solutions.Datastructure.TreeNode;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {
    static class Node{
        TreeNode node;
        int idx;
        Node(TreeNode _n, int _i){
            node = _n;
            idx = _i;
        }
    }
    int min=0;
    int max=0;
    Map<Integer,List<Integer>> map = new HashMap<>();
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> res = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();

        if(root != null)
            queue.add(new Node(root, 0));
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int idx = node.idx;
            min = Math.min(idx,min);
            max = Math.max(idx,max);
            if(!map.containsKey(idx)){
                List<Integer> list = new LinkedList<>();
                list.add(node.node.val);
                map.put(idx,list);
            }else{
                map.get(idx).add(node.node.val);
            }
            if(node.node.left != null){
                queue.offer(new Node(node.node.left, idx - 1));
            }
            if(node.node.right != null)
                queue.offer(new Node(node.node.right, idx + 1));
        }
        for(int i = min; i<= max; i++){
            if(map.containsKey(i))
                res.add(map.get(i));
        }
        return res;
    }


}
