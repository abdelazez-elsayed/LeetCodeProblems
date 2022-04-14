package solutions.TreeProblems;

import Datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {

    class Pair{
        int j;
        TreeNode node;
        Pair(TreeNode _n , int _j ){
            j = _j;
            node = _n;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        int ans = 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root,0));
        while(!queue.isEmpty()){
            int size = queue.size();
            int left = queue.peek().j;
            int right=0;
            for(int i = 0 ; i<size; i++){
                Pair p = queue.poll();
                right = p.j;
                TreeNode node = p.node;
                if(node.left != null)
                    queue.add(new Pair(node.left,2*right));
                if(node.right != null)
                    queue.add(new Pair(node.right,2*right+1));
            }
            ans = Math.max(ans,right-left+1);

        }
        return ans;
    }
}
