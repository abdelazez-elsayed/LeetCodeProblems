package solutions.TreeProblems;

import Datastructure.TreeNode;

import java.util.*;

public class VerticalOrderTraversalOfBT {
    Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map ;
    int max_left=0;
    int max_right=0;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new HashMap<>();
        getWidth(root,0,0);
        List<List<Integer>> ans = new LinkedList<>();
        for(int i = max_left; i<= max_right; i++){
            if(map.containsKey(i)){
                List<Integer> list = new LinkedList<>();
                for(Map.Entry<Integer,PriorityQueue<Integer>> entry : map.get(i).entrySet() ){
                    PriorityQueue<Integer> queue = entry.getValue();
                    while(!queue.isEmpty()){
                        list.add(queue.poll());
                    }
                }
                ans.add(list);
            }
        }
        return ans;
    }
    void getWidth(TreeNode root,int column,int row){
        if(root == null)
            return;
        if(column > max_right)
            max_right = column;
        if(column < max_left)
            max_left = column;
        if(!map.containsKey(column))
            map.put(column,new TreeMap<>());
        if(!map.get(column).containsKey(row))
            map.get(column).put(row,new PriorityQueue<>());
        map.get(column).get(row).add(root.val);
        getWidth(root.left,column-1,row+1);
        getWidth(root.right,column+1,row+1);
    }
}
