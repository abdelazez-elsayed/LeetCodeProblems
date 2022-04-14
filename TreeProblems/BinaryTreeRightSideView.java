package solutions.TreeProblems;

import Datastructure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> sol = new LinkedList<>();
        if(root == null)
            return sol;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode node = root;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                node =q.poll();
                if(node.left != null)
                    q.offer(node.left);
                if(node.right != null)
                    q.offer(node.right);
            }
            sol.add(node.val);
        }
        return sol;
    }

}
